package org.pdas.popularInterview.pipeLine;

public class Client {
    public static void main(String[] args) {
        HighThroughputPipeline pipeline = new HighThroughputPipeline();

        // Produce
        for (int i = 0; i < 1000; i++) {
            pipeline.submitTasks(new WorkTask(i, "TaskNumber: "+i));
        }

        pipeline.startConsumer();
        pipeline.shutDownGracefully();


    }
}
