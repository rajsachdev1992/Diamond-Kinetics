# Diamond Kinetics coding challenge

# Key Assumptions:
1. Timstamp is represented as Long. All other columns are represented as Doubles.
3. The data is clean (no null or blank entries).
4. The file latestSwing.csv is in the same folder from where this code is executed. (Relative path is used)

# Files
1. Driver.java : Execution starts from here. Tests all 4 operations (Hardcoded values can be changed to test other scenarios).
2. Operations.java: Contains the 4 operations that you asked me to implement.
3. GeneralUtils.java: Helper class for Operations.java.
4. Predicates.java: Contains the two predicates used by the four operations.
5. SwingData.java: Data Structure which you asked me to implement.
6. SwingFileReader: Reads the lastestSwing.csv file into the data structure.

# Note
All four operations are using the helper method "getContinuityPatternsFromData" contained in the GeneralUtils.java class.

