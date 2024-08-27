public class RemoteControlExample {

    // Command Interface
    public interface Action {
        void execute();
    }

    // Concrete Command - TurnOnAction
    public static class TurnOnAction implements Action {
        private LightSource lightSource;

        public TurnOnAction(LightSource lightSource) {
            this.lightSource = lightSource;
        }

        @Override
        public void execute() {
            lightSource.powerOn();
        }
    }

    // Concrete Command - TurnOffAction
    public static class TurnOffAction implements Action {
        private LightSource lightSource;

        public TurnOffAction(LightSource lightSource) {
            this.lightSource = lightSource;
        }

        @Override
        public void execute() {
            lightSource.powerOff();
        }
    }

    // Receiver Class
    public static class LightSource {
        public void powerOn() {
            System.out.println("The light is ON");
        }

        public void powerOff() {
            System.out.println("The light is OFF");
        }
    }

    // Invoker Class
    public static class Controller {
        private Action action;

        public void setAction(Action action) {
            this.action = action;
        }

        public void press() {
            action.execute();
        }
    }

    // Test the Command Implementation
    public static void main(String[] args) {
        LightSource light = new LightSource();
        Action turnOn = new TurnOnAction(light);
        Action turnOff = new TurnOffAction(light);

        Controller controller = new Controller();

        controller.setAction(turnOn);
        controller.press();

        controller.setAction(turnOff);
        controller.press();
    }
}
