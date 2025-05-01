// Source code is decompiled from a .class file using FernFlower decompiler.
package chat_video_consultations;

public class VideoCall {
   private String meetingLink;
   private String doctorId;
   private String patientId;

   public VideoCall(String doctorId, String patientId) {
      this.doctorId = doctorId;
      this.patientId = patientId;
      this.meetingLink = "https://meet.google.com/" + this.generateRandomId();
   }

   private String generateRandomId() {
      double var10000 = Math.random();
      return "xyz-" + (int)(var10000 * 10000.0);
   }

   public void startCall() {
      System.out.println("Starting video call between Dr." + this.doctorId + " and Patient " + this.patientId);
      System.out.println("Join at: " + this.meetingLink);
   }

   public String getMeetingLink() {
      return this.meetingLink;
   }
}
