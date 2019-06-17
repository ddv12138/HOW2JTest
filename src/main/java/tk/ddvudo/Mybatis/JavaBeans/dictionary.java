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
        String sb = "{" + "\"id\":" +
                id +
                ",\"receive\":\"" +
                receive + '\"' +
                ",\"response\":\"" +
                response + '\"' +
                '}';
        return sb;
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
