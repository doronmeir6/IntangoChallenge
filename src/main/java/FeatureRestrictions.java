import java.util.*;

public class FeatureRestrictions {


    Map<FEATUREKEYS, Set<String>> enumToFeatureSet;

    /**
     * constructor
     */
    public FeatureRestrictions() {
        enumToFeatureSet = new HashMap<>();
        enumToFeatureSet.put(FEATUREKEYS.Phone, arraysValuesToSet(phoneArray));
        enumToFeatureSet.put(FEATUREKEYS.OS, arraysValuesToSet(OSArray));
        enumToFeatureSet.put(FEATUREKEYS.ProductType, arraysValuesToSet(prodTypeArray));
        enumToFeatureSet.put(FEATUREKEYS.Manufacturer, arraysValuesToSet(manufacturerArray));
        enumToFeatureSet.put(FEATUREKEYS.ScreenSize, arraysValuesToSet(screenSizeArray));
        enumToFeatureSet.put(FEATUREKEYS.Resolution, arraysValuesToSet(ResolutionArray));
        enumToFeatureSet.put(FEATUREKEYS.FrontCamera, arraysValuesToSet(frontCameraArray));
        enumToFeatureSet.put(FEATUREKEYS.BackCamera, arraysValuesToSet(backCameraArray));
        enumToFeatureSet.put(FEATUREKEYS.Gyroscope, arraysValuesToSet(GyroscopeArray));

    }

    /**
     * converts array to set
     *
     * @param flist
     * @return set<String>
     */
    public Set<String> arraysValuesToSet(String[] flist) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, flist);
        return set;
    }

    /**
     * getter
     *
     * @return
     */
    public Map<FEATUREKEYS, Set<String>> getEnumToFeatureSet() {
        return enumToFeatureSet;
    }
    ///keys

    /**
     * feature names as enums to restrict user insertion
     */
    enum FEATUREKEYS {
        Phone, OS, ProductType, Manufacturer, ScreenSize, Resolution, FrontCamera, BackCamera, Gyroscope
    }

    /**
     * values allowed to be inserted
     */
    final private String[] phoneArray = {"Smartphone", "Feature"};
    final private String[] OSArray = {"Android", "iOS"};
    final private String[] prodTypeArray = {"Tablet", "MobilePhone", "SmartTV"};
    final private String[] manufacturerArray = {"Apple", "Samsung", "LG", "Xiaomi"};
    final private String[] screenSizeArray = {"small_Screen_Size", "medium_Screen_Size", "big_Screen_Size", "XL_Screen_Size"};
    final private String[] ResolutionArray = {"RES_720x1280", "RES_750x1334", "RES_640x1136", "RES_1080x1920", "RES_1440x2560"};
    final private String[] frontCameraArray = {"Front Camera"};
    final private String[] backCameraArray = {"Back Camera"};
    final private String[] GyroscopeArray = {"Gyroscope"};
}
