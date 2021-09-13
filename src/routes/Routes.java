package routes;

public enum Routes {
    
    MAIN_VIEW("../ui/assets/main.fxml"), INPUT_VIEW("../ui/assets/input.fxml"),  STORE_VIEW("../ui/assets/store.fxml"),  
    RESULT_VIEW("../ui/assets/results.fxml");

    private String route;

    private Routes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
