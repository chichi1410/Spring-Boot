package vn.hoa.Spring.spring_project_CRUD.hanle;

public class ErrorResponse extends RuntimeException {
    private int status;
    private String message;
    private long timestamp;


    public ErrorResponse(int status , String message) {

        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
