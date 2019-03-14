package tk.ddvudo.Mybatis;

public class dictionary {
    int id;
    String receive;
    String response;

    public dictionary(String receive, String response) {
        this.receive = receive;
        this.response = response;
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

    @Override
    public String toString() {
        return "dictionary{" +
                "id=" + id +
                ", receive='" + receive + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
