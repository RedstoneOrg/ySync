package slice.brasil.ysync;

public class ySyncProcess {

    private ySync clazz;

    public ySyncProcess(ySync clazz){
        this.clazz = clazz;
    }


    /**
     * class.preExecute() é executado antes da Thread ser iniciada
     * class.setRunning(true) coloca para a Classe estar como iniciada em quanto roda a Thread nova
     * class.execute() retorna um valor booleano para identificar se veio como valor verdadeiro
     * class.posExecute() também booleano é para identificar o valor do onCompletion()
     *
     * class.isRunCompletion() for igual valor true, a classe será executada.
     *
     * class.onCompletion() é oque acontece após tudo ser executado na Thread, mas retornando
     * valores falso no execute ou no posExecute é possivel fazer com que o onCompletion não seja
     * executado.
     */
    public void process(){
        clazz.preExecute();
        Thread thread = new Thread(() -> {
            clazz.setRunning(true);
            boolean executed = clazz.execute();
            if(executed) {
                boolean pos = clazz.posExecute();
                clazz.setRunning(false);
                if(pos && clazz.isRunCompletion()){
                    clazz.onCompletion();
                }
            } else {
                clazz.setRunning(false);
            }
        });
        thread.start();
    }

}
