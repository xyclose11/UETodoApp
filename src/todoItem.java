import java.util.Date;

public class todoItem {
    public String name;

    public  String body;
    public Date dueDate;
    private final Date createdAt;
    private final Date updatedAt;

    public todoItem() {
        this.name = "";
        this.body = "";
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.dueDate = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getBody() {
        return body;
    }

    public String getName() {
        return name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

}
