// Source code is decompiled from a .class file using FernFlower decompiler.
package emergency_alert_system;

public class PanicButton {
   private EmergencyAlert emergencyAlert;

   public PanicButton(EmergencyAlert emergencyAlert) {
      this.emergencyAlert = emergencyAlert;
   }

   public void press() {
      this.emergencyAlert.triggerAlert("Patient pressed panic button!", true);
   }
}
