package org.engine.plugin.transactions.factory;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.io.*;

public class ObjectFactorySerializer implements Serializer<Object> {

    @Override
    public byte[] serialize(String topic, Object data) {
        return null;
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Object data) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(data);
            return baos.toByteArray();
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
