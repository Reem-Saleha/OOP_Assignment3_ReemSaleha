// Source code is decompiled from a .class file using FernFlower decompiler.
package chat_video_consultations;

import java.util.ArrayList;
import java.util.List;

public class ChatServer {
   private List<String> messages = new ArrayList();

   public ChatServer() {
   }

   public void sendMessage(String sender, String recipient, String message) {
      String formattedMessage = sender + " to " + recipient + ": " + message;
      this.messages.add(formattedMessage);
      System.out.println("Message sent: " + formattedMessage);
   }

   public List<String> getMessages() {
      return new ArrayList(this.messages);
   }
}
