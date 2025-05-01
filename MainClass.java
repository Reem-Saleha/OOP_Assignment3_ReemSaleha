// Source code is decompiled from a .class file using FernFlower decompiler.
import chat_video_consultations.ChatClient;
import chat_video_consultations.ChatServer;
import chat_video_consultations.VideoCall;
import emergency_alert_system.EmergencyAlert;
import emergency_alert_system.NotificationService;
import emergency_alert_system.PanicButton;
import java.time.LocalDateTime;
import notification_reminders.EmailNotification;
import notification_reminders.Notifiable;
import notification_reminders.ReminderService;
import notification_reminders.SMSNotification;

public class MainClass {
   public Main() {
   }

   public static void main(String[] args) {
      ChatServer chatServer = new ChatServer();
      ChatClient doctorChat = new ChatClient("Dr123", chatServer);
      ChatClient patientChat = new ChatClient("Pt456", chatServer);
      doctorChat.sendMessage("Pt456", "Hello, how are you feeling today?");
      patientChat.sendMessage("Dr123", "Feeling a bit dizzy since morning.");
      VideoCall videoCall = new VideoCall("Dr123", "Pt456");
      videoCall.startCall();
      EmergencyAlert emergencyAlert = new EmergencyAlert("Pt456");
      PanicButton panicButton = new PanicButton(emergencyAlert);
      panicButton.press();
      Notifiable emailNotifier = new EmailNotification();
      Notifiable smsNotifier = new SMSNotification();
      NotificationService alertService = new NotificationService(smsNotifier);
      alertService.sendAlert("Dr123", emergencyAlert.getAlertMessage());
      ReminderService reminderService = new ReminderService(emailNotifier);
      reminderService.sendAppointmentReminder("Pt456", LocalDateTime.now().plusDays(1L));
      reminderService.sendMedicationReminder("Pt456", "Aspirin", "1 tablet");
      reminderService.setNotificationMethod(smsNotifier);
      reminderService.sendAppointmentReminder("Pt456", LocalDateTime.now().plusDays(2L));
   }
}
