import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test extends TestCase {

    AppleTV appleTV;
    Galaxy10Plus galaxy10Plus;
    GPad7 gPad7;
    Mi9 mi9;

    // assigning the values
    protected void setUp() {
        appleTV = new AppleTV();
        galaxy10Plus = new Galaxy10Plus();
        gPad7 = new GPad7();
        mi9 = new Mi9();
    }

    /**
     * test all features,none of them are missing compare expected list to actual list we get.
     */
    public void testCorrectness() {
        try {
            List<String> expectedFeaturesList = new ArrayList<>();
            expectedFeaturesList.add("Smartphone");
            expectedFeaturesList.add("MobilePhone");
            expectedFeaturesList.add("Android");
            expectedFeaturesList.add("Samsung");
            expectedFeaturesList.add("RES_1440x2560");
            expectedFeaturesList.add("XL_Screen_Size");
            expectedFeaturesList.add("Front Camera");
            expectedFeaturesList.add("Back Camera");
            expectedFeaturesList.add("Gyroscope");
            Collections.sort(expectedFeaturesList);

            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.Phone, "Smartphone");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.ProductType, "MobilePhone");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.OS, "Android");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.Manufacturer, "Samsung");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.ScreenSize, "XL");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.Resolution, "1440x2560");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.FrontCamera, "Front Camera");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.BackCamera, "Back Camera");
            galaxy10Plus.putFeature(FeatureRestrictions.FEATUREKEYS.Gyroscope, "Gyroscope");
            List<String> listOfFeatures = galaxy10Plus.getFeatures();
            Collections.sort(listOfFeatures);
            assertEquals(listOfFeatures, expectedFeaturesList);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Could not put all features");
        }
    }


    /**
     * test some features,some of them are missing compare expected list to actual list we get.
     */
    public void testSomeFeatures() {
        try {
            List<String> expectedFeaturesList = new ArrayList<>();
            expectedFeaturesList.add("SmartTV");
            expectedFeaturesList.add("iOS");
            expectedFeaturesList.add("Apple");
            expectedFeaturesList.add("RES_1440x2560");
            Collections.sort(expectedFeaturesList);

            appleTV.putFeature(FeatureRestrictions.FEATUREKEYS.ProductType, "SmartTV");
            appleTV.putFeature(FeatureRestrictions.FEATUREKEYS.OS, "iOS");
            appleTV.putFeature(FeatureRestrictions.FEATUREKEYS.Manufacturer, "Apple");
            appleTV.putFeature(FeatureRestrictions.FEATUREKEYS.Resolution, "1440x2560");
            List<String> listOfFeatures = appleTV.getFeatures();
            Collections.sort(listOfFeatures);
            assertEquals(listOfFeatures, expectedFeaturesList);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Could not put all features");
        }
    }


    /**
     * test some features,some of them are missing.
     * give one of the features for example 'Resolution' a value it doesn't support and see exception is thrown .
     */
    public void testWrongValuesInFeatures() {
        try {

            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.Phone, "Smartphone");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.ProductType, "Tablet");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.OS, "Android");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.Manufacturer, "LG");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.ScreenSize, "small");
            ///no such resolution
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.Resolution, "2200x3600");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.FrontCamera, "Front Camera");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.Gyroscope, "Gyroscope");
            gPad7.putFeature(FeatureRestrictions.FEATUREKEYS.Gyroscope, "Gyroscope");

            Assert.fail("Bad Resolution was inserted, instead of throwing new Exception");
        } catch (Exception e) {
            String message = e.getMessage();
            Assert.assertEquals("there is no value option 'RES_2200x3600' in list values of key: Resolution", message);
        }
    }


    /**
     * test no features,should give an empty list of strings.
     */
    public void testEmptyFeatures() {
        List<String> listOfFeatures = mi9.getFeatures();
        assertTrue(listOfFeatures.isEmpty());
    }


    /**
     * test some features,dealing with null values.null values should throw error.
     */
    public void testNullFeaturesValues() {

        try {

            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.Phone, "Smartphone");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.ProductType, "MobilePhone");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.OS, "Android");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.Manufacturer, "Xiaomi");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.ScreenSize, null);
            Assert.fail("null value was inserted!!!");
        } catch (Exception e) {
            ///validate exception was thrown
            String message = e.getMessage();
            Assert.assertEquals("value cant be 'null'", message);
            //rest of the list should not be changed
            List<String> listOfFeatures = mi9.getFeatures();
            Collections.sort(listOfFeatures);
            List<String> expectedFeaturesList = new ArrayList<>();
            expectedFeaturesList.add("Smartphone");
            expectedFeaturesList.add("MobilePhone");
            expectedFeaturesList.add("Android");
            expectedFeaturesList.add("Xiaomi");
            Collections.sort(expectedFeaturesList);
            assertEquals(listOfFeatures, expectedFeaturesList);
        }
    }


    /**
     * test some features,dealing with null Features.null Features should throw error.
     */
    public void testNullFeatures() {

        try {

            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.Phone, "Smartphone");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.ProductType, "MobilePhone");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.OS, "Android");
            mi9.putFeature(FeatureRestrictions.FEATUREKEYS.Manufacturer, "Xiaomi");
            mi9.putFeature(null, "1440x2560");
            Assert.fail("null feature  was inserted!!!");
        } catch (Exception e) {
            ///validate exception was thrown
            String message = e.getMessage();
            Assert.assertEquals("Feature name cant be 'null' must be enum", message);
            //rest of the list should not be changed
            List<String> listOfFeatures = mi9.getFeatures();
            Collections.sort(listOfFeatures);
            List<String> expectedFeaturesList = new ArrayList<>();
            expectedFeaturesList.add("Smartphone");
            expectedFeaturesList.add("MobilePhone");
            expectedFeaturesList.add("Android");
            expectedFeaturesList.add("Xiaomi");
            Collections.sort(expectedFeaturesList);
            assertEquals(listOfFeatures, expectedFeaturesList);
        }
    }
}
