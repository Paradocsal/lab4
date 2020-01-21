import items.DepletableLightSource;

public interface Action {
    void addLightToList(DepletableLightSource dls);
    void refreshEnvironment();
}
