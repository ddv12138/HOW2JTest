package tk.ddvudo.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import tk.ddvudo.Mybatis.JavaBeans.Enterprise;
import tk.ddvudo.Mybatis.JavaBeans.EnterpriseExample;
import tk.ddvudo.Mybatis.UseAnnotation.EnterpriseDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Sample {
	private static final String ELASTICSEARCH_URL = "127.0.0.1";
	private static final short ELASTICSEARCH_PORT = 9200;
	//High Level Client init
	private static final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
			new HttpHost(ELASTICSEARCH_URL, ELASTICSEARCH_PORT)));

	public static void main(String... args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
		EnterpriseExample example = new EnterpriseExample();
		example.setOrderByClause("\"Id\"");
		example.setOffset((long) 250500);
//		example.setLimit(50000);
		myResultHandler<Enterprise> resultHandler = new myResultHandler<>();
		enterpriseDao.selectByExample_Map_Forward(example, resultHandler);
		resultHandler.handle();
		client.close();
	}

	static class myResultHandler<E> implements ResultHandler {
		private final short MAX_POOL_SIZE = 500;
		private final Set<IndexRequest> requestSet = new HashSet<>();
		int count = 0;

		@Override
		public void handleResult(ResultContext resultContext) {
			Enterprise tmp = (Enterprise) resultContext.getResultObject();
			IndexRequest request = new IndexRequest().id(String.valueOf(tmp.getId())).index("enterprise");
			request.source(JSON.toJSONString(tmp), XContentType.JSON);
			requestSet.add(request);
			if (requestSet.size() == MAX_POOL_SIZE) {
				this.handle();
			}
		}

		private void handle() {
			if (requestSet.size() == 0)
				return;
			BulkRequest bulkRequest = new BulkRequest();
			requestSet.forEach(bulkRequest::add);
			try {
				client.bulk(bulkRequest, RequestOptions.DEFAULT);
				count += MAX_POOL_SIZE;
				System.out.println(new Date().toString() + "--累计" + count + "条");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				requestSet.clear();
			}
		}
	}
}
