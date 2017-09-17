package slice.brasil.ysync;

public abstract class ySync {

    private Object[] data;

    private boolean isRunning = false;

    private boolean runCompletion = true;

    /**
     * ySync Name
     */
    public abstract String getName();

    /**
     * PreExecute running in MainThread
     */
    public abstract void preExecute();

    /**
     * Execute in NewThread
     */
    public abstract boolean execute();

    /**
     * Execute in NewThread pos executedData
     */
    public abstract boolean posExecute();

    /**
     * onCompletion executed posExecute thread
     */
    public abstract void onCompletion();

    /**
     * @return bool
     */
    public boolean isRunning(){
        if (this.isRunning) return true;
        else return false;
    }

    /**
     * @param $value
     */
    protected void setRunning(boolean $value){
        if ($value) this.isRunning = true;
        else this.isRunning = false;
    }

    public void setRunCompletion(boolean runCompletion) {
        if (runCompletion) this.runCompletion = true;
        else this.runCompletion = false;
    }

    public boolean isRunCompletion() {
        if (runCompletion) return true;
        else return false;
    }
}
