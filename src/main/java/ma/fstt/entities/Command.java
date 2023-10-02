package ma.fstt.entities;

import java.sql.Date;

public class Command {
    private Long id;
    private Date date;
    private String label;
    private String status;
    private String deliveryAddr;

    private Client client;

    public Command(Long id, String label, Date date, String status, String deliveryAddr) {
        this.id = id;
        this.date = date;
        this.label = label;
        this.status = status;
        this.deliveryAddr = deliveryAddr;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", date=" + date +
                ", label='" + label + '\'' +
                ", status='" + status + '\'' +
                ", deliveryAddr='" + deliveryAddr + '\'' +
                ", client=" + client +
                '}';
    }

    public Command() {}

}
