package tk.ddvudo.Mybatis.JavaBeans;

public class dictionary {
    int id;
    String receive;
    String response;

    public dictionary(String receive, String response) {
        this.receive = receive;
        this.response = response;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"receive\":\"")
                .append(receive).append('\"');
        sb.append(",\"response\":\"")
                .append(response).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public dictionary() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
