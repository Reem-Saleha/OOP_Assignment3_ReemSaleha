// Source code is decompiled from a .class file using FernFlower decompiler.
package chat_video_consultations;

public class ChatClient {
   private String userId;
   private ChatServer chatServer;

   public ChatClient(String userId, ChatServer chatServer) {
      this.userId = userId;
      this.chatServer = chatServer;
   }

   public void sendMessage(String recipient, String message) {
      this.chatServer.sendMessage(this.userId, recipient, message);
   }
}
