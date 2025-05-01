// Source code is decompiled from a .class file using FernFlower decompiler.
package emergency_alert_system;

import notification_reminders.Notifiable;

public class NotificationService {
   private Notifiable notificationMethod;

   public NotificationService(Notifiable notificationMethod) {
      this.notificationMethod = notificationMethod;
   }

   public void sendAlert(String recipient, String message) {
      this.notificationMethod.sendNotification(recipient, message);
   }

   public void setNotificationMethod(Notifiable notificationMethod) {
      this.notificationMethod = notificationMethod;
   }
}
