import java.time.LocalDate;

public class Task{

    private int task_id;
    private String description;
    private String status = "Ongoing";
    private LocalDate current_date;
    private LocalDate due_date;

    public Task(int task_id, String description, String status, LocalDate current_date, LocalDate due_Date)
    {
        this.task_id = task_id;
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

    public int gettaskid(){
        return task_id;
    }

    //Set method

    public void settaskid(int task_id){
        this.task_id = task_id;
    }

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
