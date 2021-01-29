package org.engine.plugin.transactions.factory;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ResponseFactorySerializer implements Serializable, Serializer<AuthResponseFactory> {

    @Override
    public byte[] serialize(String topic, AuthResponseFactory data)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(data);
            out.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Unhandled", e);
        }
        return out.toByteArray();
    }
}
