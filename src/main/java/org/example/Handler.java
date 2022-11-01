package org.example;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public class Handler implements RequestHandler<Map<String,String>, String>{
    private static final Logger logger = LoggerFactory.getLogger(Handler.class);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public String handleRequest(Map<String,String> event, Context context)
    {
        String response = new String("200 OK");
        // log execution details
        logger.info("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.info("CONTEXT: " + gson.toJson(context));
        // process event
        logger.info("EVENT: " + gson.toJson(event));
        logger.warn("EVENT TYPE: " + event.getClass().toString());
        return response;
    }
}