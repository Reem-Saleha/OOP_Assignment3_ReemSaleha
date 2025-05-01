// Source code is decompiled from a .class file using FernFlower decompiler.
package emergency_alert_system;

public class EmergencyAlert {
   private String patientId;
   private String alertMessage;
   private boolean isCritical;

   public EmergencyAlert(String patientId) {
      this.patientId = patientId;
   }

   public void triggerAlert(String message, boolean critical) {
      this.alertMessage = message;
      this.isCritical = critical;
      System.out.println("ALERT for Patient " + this.patientId + ": " + message);
      if (critical) {
         System.out.println("CRITICAL ALERT! Notifying emergency contacts.");
      }

   }

   public String getAlertMessage() {
      return this.alertMessage;
   }

   public boolean isCritical() {
      return this.isCritical;
   }
}
