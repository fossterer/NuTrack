Database:       nutrack

1) Table:          days

Primary Key:    Date
Columns:        Date    Meal-1      Meal-2      Meal-3      Meal-4
Datatype(s):    Date    meal unique id --         --      --

2) Table:          meals

Primary Key:    meal unique id
Columns:        meal unique id      itemName        quantity
Datatype(s):        string              string      string

Questions that need mulling over: Friday Nov 08 2019 2:00 AM
- A user can have any no. of meals in a given day -- can't decide no. of columns in 'days' table as above
- A meal can have any no. of items -- storing JSON in a column means *not searchable* (eg. How many times in a week certain food has been eaten? etc.)
                                    -- having another 'meals' table leads to multiple entries of same itemNam-quantity pairs but with different unique ids

Is a relational model itself an incorrect choice for this problem?
Should 'SharedPreferences' API of Android be used? -- Can you *JOIN* when needed in this case?
(or) should we use a non-Relational database inside Android?
    - We might look into "Realm" as a potential provider of non-relational databse.
    However, for the sake of #1PPM, we'll be fixing on that

    (Task decided at **Friday Nov 08 2019 2:00 AM**)

    - A user would have to enter in terms of 4 meals a day only
    - A meal entry in a 'day' table would be a JSON structure with unlimited no. of itemName-quantity pairs.
        It is accepted that the meals, once entered are not searchable easily

Date: Mon Nov 11 2019
=====================

We are going to use Room library for database operations

1) Entity class - Day
   1) Columns: Date, Meal-1, Meal-2, Meal-3, Meal-4
2) Database - nuTrack_username
   1) Reurns DayDao
3) DAO - DayDao
   1) Methods - Select, Insert, Update, Delete

For Tue Nov 12 2019 - Write TypeAdapter for type 'java.util.Date'

Date: Tue Nov 12 2019
=====================

(1) Eliminate "Date" type everywhere. Convert even the TypeAdapters to refer to GregorianCalendar.
(2) Add insert button and trigger insert() method. Show it back on read()

Date: Wed Nov 13 2019
=====================

(1) The "Date" isn't doing it (with its time component that messes data fetching). Just store as String and get rid of DateTypeAdapter
(2) "Observe" the "LiveData" ! For insertions/updations, use setValue() (or postValue())
(2) Add insert button and trigger insert() method. Show it back on read()
