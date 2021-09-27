package routes;

public enum Routes {
    
    MAIN_VIEW("../ui/assets/main.fxml"), INPUT_VIEW("../ui/assets/input.fxml"),  STORE_VIEW("../ui/assets/store.fxml"),  
    RESULT_VIEW("../ui/assets/results.fxml"), GAMES_DATA("./data/GAMES_DATA.csv"),
    ADD_CLIENT_VIEW("../ui/assets/addClientModal.fxml"),ADD_CASHIER_VIEW("../ui/assets/addCashierModal.fxml"),GAME_INFORMATION_VIEW("../ui/assets/gameInformationModal.fxml");

    private String route;

    private Routes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
