package Interviews.glance.events.stream;

import java.util.UUID;

public class VideoStream implements LiveStream{

    public String getStreamId(){
        return UUID.randomUUID().toString();
    }
}
