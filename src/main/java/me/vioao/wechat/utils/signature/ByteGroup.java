package me.vioao.wechat.utils.signature;

import java.util.ArrayList;

class ByteGroup {
    private ArrayList<Byte> byteContainer = new ArrayList<>();

    byte[] toBytes() {
        byte[] bytes = new byte[byteContainer.size()];
        for (int i = 0; i < byteContainer.size(); i++) {
            bytes[i] = byteContainer.get(i);
        }
        return bytes;
    }

    ByteGroup addBytes(byte[] bytes) {
        for (byte b : bytes) {
            byteContainer.add(b);
        }
        return this;
    }

    int size() {
        return byteContainer.size();
    }
}
