# SimpleAndroidContactApp

## Program Description
```
This Contacts Application was designed to store contact information of a person consist of basic
information such as Name, Address, Phone Number, and Email.This apps have a basic
functionalities such as add contact into a database,search for the specific name inside the
saved contact database, delete and edit contacts and make a call or sent a mail based on the
contact information.
```

The​ ​ list​ ​ of​ ​ saved​ ​ contact​ ​ will​ ​ be​ ​ stored​ ​ in​ ​ a ​ ​ local​ ​ SQLite​ ​ database​ ​ on​ ​ the​ ​ phone​ ​ and​ ​ get
displayed​ ​ through​ ​ the​ ​ Recyclerview​ ​ widget​ ​ inside​ ​ android.​ ​ The​ ​ recyclerview​ ​ list​ ​ hold​ ​ a ​ ​ cardview
widget​ ​ with​ ​ help​ ​ of​ ​ custom​ ​ recyclerview​ ​ adapter​ ​ that​ ​ inflate​ ​ a ​ ​ custom​ ​ layout​ ​ to​ ​ display
information​ ​ such​ ​ as​ ​ image,​ ​ name,​ ​ email​ ​ and​ ​ phone​ ​ number​ ​ in​ ​ the​ ​ recyclerview​ ​ list.
When​ ​ an​ ​ item​ ​ inside​ ​ the​ ​ list​ ​ (a​ ​ contact)​ ​ is​ ​ clicked,​ ​ a ​ ​ new​ ​ activity​ ​ will​ ​ be​ ​ start​ ​ to​ ​ display​ ​ a ​ ​ more
details​ ​ information​ ​ of​ ​ the​ ​ contacts.​ ​ From​ ​ that​ ​ details​ ​ information​ ​ activity,​ ​ a ​ ​ user​ ​ will​ ​ be​ ​ able​ ​ to
make​ ​ a ​ ​ call​ ​ or​ ​ send​ ​ a ​ ​ mail​ ​ to​ ​ that​ ​ specific​ ​ contact​ ​ information​ ​ by​ ​ clicking​ ​ the​ ​ cardview​ ​ that​ ​ hold
the​ ​ information​ ​ such​ ​ as​ ​ phone,​ ​ email,address.​ ​ On​ ​ that​ ​ details​ ​ information​ ​ activity,​ ​ on​ ​ a ​ ​ right​ ​ top
corner​ ​ there​ ​ is​ ​ a ​ ​ menu​ ​ where​ ​ user​ ​ can​ ​ choose​ ​ an​ ​ option​ ​ to​ ​ delete​ ​ or​ ​ edit​ ​ the​ ​ contact.​ ​ If​ ​ choosed
to​ ​ delete​ ​ the​ ​ apps​ ​ will​ ​ delete​ ​ current​ ​ contact​ ​ from​ ​ the​ ​ database,​ ​ else​ ​ if​ ​ choosed​ ​ to​ ​ edit,​ ​ a ​ ​ new
activity​ ​ will​ ​ be​ ​ start​ ​ to​ ​ edit​ ​ the​ ​ contact​ ​ information.
Through​ ​ a ​ ​ floating​ ​ action​ ​ button​ ​ on​ ​ the​ ​ main​ ​ activity,​ ​ user​ ​ can​ ​ click​ ​ that​ ​ button​ ​ to​ ​ add​ ​ new
contact​ ​ to​ ​ their​ ​ database.​ ​ When​ ​ the​ ​ button​ ​ clicked​ ​ a ​ ​ new​ ​ activity​ ​ will​ ​ appear​ ​ for​ ​ user​ ​ to​ ​ key​ ​ in
the​ ​ new​ ​ information​ ​ to​ ​ be​ ​ added.​ ​ In​ ​ Details​ ​ view​ ​ (Main2Activity.java)​ ​ activity​ ​ there​ ​ is​ ​ also​ ​ a
floating​ ​ action​ ​ button​ ​ that​ ​ when​ ​ user​ ​ click​ ​ on​ ​ that​ ​ button​ ​ a ​ ​ Message​ ​ activity​ ​ will​ ​ pop​ ​ up​ ​ enable
user​ ​ to​ ​ sent​ ​ message​ ​ to​ ​ that​ ​ contact.
This​ ​ app​ ​ also​ ​ have​ ​ the​ ​ function​ ​ to​ ​ search​ ​ through​ ​ the​ ​ list​ ​ of​ ​ contacts​ ​ and​ ​ only​ ​ show​ ​ the​ ​ relevant
contact​ ​ on​ ​ the​ ​ recyclerview​ ​ based​ ​ on​ ​ the​ ​ name​ ​ the​ ​ user​ ​ search​ ​ for.​ ​ SearchView​ ​ and​ ​ database
query​ ​ were​ ​ implemented​ ​ for​ ​ the​ ​ search​ ​ functionality​ ​ to​ ​ works.

## ScreenShots
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654750.png)
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654766.png)
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654772.png)
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654787.png)
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654794.png)
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654816.png)
![Screenshots](https://github.com/nurbxfit/SimpleAndroidContactApp/blob/master/images/Screenshot_1538654824.png)
