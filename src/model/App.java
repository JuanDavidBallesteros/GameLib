package model;

public class App {

    private QueueTAD<Client> clients;
    private Stage1 s1;
    private Stage2 s2;
    private Stage3 s3;
    private Stage4 s4;

    public App() {
    }

    public QueueTAD<Client> getClients() {
        return clients;
    }

    public void setClients(QueueTAD<Client> clients) {
        this.clients = clients;
    }

    public Stage1 getS1() {
        return s1;
    }

    public void setS1(Stage1 s1) {
        this.s1 = s1;
    }

    public Stage2 getS2() {
        return s2;
    }

    public void setS2(Stage2 s2) {
        this.s2 = s2;
    }

    public Stage3 getS3() {
        return s3;
    }

    public void setS3(Stage3 s3) {
        this.s3 = s3;
    }

    public Stage4 getS4() {
        return s4;
    }

    public void setS4(Stage4 s4) {
        this.s4 = s4;
    }

        
}
