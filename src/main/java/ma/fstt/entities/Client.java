package ma.fstt.entities;

import java.util.List;

public class Client {
    private Long id;
    private String name;
    private String address;
    private String phone;

    private List<Command> commands;

    public Client() {}

    public Client(Long id, String name, String address, String phone) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }



    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
    }
}
