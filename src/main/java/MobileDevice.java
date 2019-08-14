import java.util.*;

public abstract class MobileDevice {

    /**
     * instance variables
     */
    private Map<FeatureRestrictions.FEATUREKEYS, String> featuresMap;
    private FeatureRestrictions featureRestrictions;

    /**
     * constructor
     */
    public MobileDevice() {
        this.featureRestrictions = new FeatureRestrictions();
        this.featuresMap = new LinkedHashMap<>();
    }


    /** insert feature to feature map
     * @param key
     * @param value
     * @throws Exception
     */
    public void putFeature(FeatureRestrictions.FEATUREKEYS key, String value) throws Exception {
        if(value == null)
            throw new Exception("value cant be 'null'");
        if(key == null)
            throw new Exception("Feature name cant be 'null' must be enum");

        switch (key) {

            case Phone:
                put(FeatureRestrictions.FEATUREKEYS.Phone, value);
                break;
            case OS:
                put(FeatureRestrictions.FEATUREKEYS.OS, value);
                break;
            case ProductType:
                put(FeatureRestrictions.FEATUREKEYS.ProductType, value);
                break;
            case Manufacturer:
                put(FeatureRestrictions.FEATUREKEYS.Manufacturer, value);
                break;
            case ScreenSize:
                put(FeatureRestrictions.FEATUREKEYS.ScreenSize, value + "_Screen_Size");
                break;
            case Resolution:
                put(FeatureRestrictions.FEATUREKEYS.Resolution, "RES_"+value);
                break;
            case FrontCamera:
                put(FeatureRestrictions.FEATUREKEYS.FrontCamera, value);
                break;
            case BackCamera:
                put(FeatureRestrictions.FEATUREKEYS.BackCamera, value);
                break;
            case Gyroscope:
                put(FeatureRestrictions.FEATUREKEYS.Gyroscope, value);
                break;
        }

    }

    /**
     * @param key enum of features such as : 'Phone', 'OS', 'ProductType', Manufacturer, ScreenSize,
     *            Resolution, FrontCamera, BackCamera, Gyroscope.
     * @param value value for the specific enum
     * @throws Exception
     */
    protected void put(FeatureRestrictions.FEATUREKEYS key, String value) throws Exception {
        if (featureRestrictions.getEnumToFeatureSet().get(key).contains(value)) {
            featuresMap.put(key, value);
        } else {
            throw new Exception("there is no value option '" + value + "' in list values of key: " + key);
        }
    }

    /**
     * get list of all prototypes features
     *
     * @return list of features
     */
    public List<String> getFeatures() {
        return new ArrayList<>(featuresMap.values());
    }
}
