# Backend-Technologies-Project
## Labs for Backend technologies

### Instructions on how to run the program locally
- Install docker desktop on your computer
- In docker desktop search for the image *lesflqq/back-tech-project*
- Click **Pull**, and then **Run**
- Сreate a new container and specify **8080** in the Port(s) field
- When the program starts, test endpoints from postman's collection

### Варіант завдання для третьої лабораторної роботи


Варіант визначаємо за остачею від ділення свого номеру групи на 3.
Мій варіант = 2423, звідси **2423 % 3 = 2**.
- Отже, моє завдання - Користувацькі категорії витрат

(повинні бути загальні категорії витрат, які видно всім користувачам, та користувацькі, які можуть вказати тільки користувачі, які їх визначили)

#### Для виконання цього завдання я додав 3 ендпоінти:
- */visible/{userId}* - Переглянути усі видимі категорії для користувача.
- */global* - Переглянути усі глобальні категорії.
- */private/{userId}* - Переглянути усі тільки приватні категорії для користувача.