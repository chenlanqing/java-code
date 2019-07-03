Netty解决粘包和拆包
---

- 1、LineBasedFrameDecoder、StringDecoder

    LineBasedFrameDecoder + StringDecoder组合就是按行切换的文本解码器
    
- 2、DelimiterBasedFrameDecoder：可以自动完成以分隔符做结束标志的消息的解码

- 3、FixedLengthFrameDecoder：以自动完成对定长消息的解码