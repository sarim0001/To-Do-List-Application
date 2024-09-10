import java.time.LocalDate;

public class Task{

    private String description;
    private String status;
    private LocalDate current_date;
    private LocalDate due_date;

    public Task(String description, String status, LocalDate current_date, LocalDate due_Date)
    {
        this.description = description;
        this.status = status;
        this.current_date = current_date;
        this.due_date = due_Date;        
    }

    //Get methods

    public String getDescription() {
        return description;
    }
    
    public String getStatus() {
        return status;
    }

    public LocalDate getCurrent_date() {
        return current_date;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    //Set method

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrent_date(LocalDate current_date) {
        this.current_date = current_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

}
