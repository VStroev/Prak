# Prak
Домашняя работа по практикуму на ЭВМ. 

Вар 17: Видеопрокат

Система управления данными о видеокассетах и дисках, об их выдаче клиентам.

Поддерживаемые данные

    Клиенты
        ФИО
        Контактная информация: адрес, телефон
        Какие носители с фильмами, когда и по какой цене ему выдавались, когда он их возвращал
    Фильмы
        Название
        Компания, режиссер, год выхода
        Носители (кассеты, диски) и стоимость проката каждого типа носителя
        Количество экземпляров на каждом типе носителя и свободных экземпляров
        Для каждого экземпляра: кому и когда его выдавали, когда он возвращался

Поддерживаемые операции

    Получение списка клиентов и фильмов
    Получение истории выдачи и приема фильмов у клиента, списка находящихся у него фильмов
    Получение истории выдачи и приема экземпляров фильма, сводных сведений о наличии, выдаче и приеме фильмов за заданный интервал времени
    Внесение информации о выдаче фильма клиенту, получении от него и оплате
    Добавление и удаление клиента, чтение и редактирование данных о нем
    Добавление и удаление фильма и отдельных экземпляров, чтение и редактирование данных о фильмах и их экземплярах

Use cases: 

    Получить список доступных фильмов.
    Получить список клиентов взявших определенный фильм. 
    Получить историю клиента.
    Получение истоии экземпляра. 
    Передача экземпляра клиента и его возвращение. 
    Добавление/удаление клиента.
    Доавление/удаление фильма.  

# Схема бд:

![index](https://cloud.githubusercontent.com/assets/18196156/23093687/bf5d5e66-f603-11e6-8d12-3262148d7072.png)

# Схема сайта:

![untitled diagram 2](https://cloud.githubusercontent.com/assets/18196156/23220576/e27f7736-f93b-11e6-9dab-2aeeaa40c020.png)

Прямоугольники - страницы, овалы - кнопки.

# Краткое содержание страниц:

Главная: инфо о салоне видеопроката

Фильмы: список фильмов с информацией о количетве доступных экземляров разного вида.

Добавление фильма: поля с информацией о фильме, для заполнения.

Инфо о фильме: вся информация о фильме.

Экземпляры: список экземпляров по индексам, у занятых указан клиент у которого на руках находится данный экземпляр.

История экземпляра: информация когда и у кого он был на руках

Клиенты: список клиентов

Добавление клиента: поля с информацией о клиенте для заполнения.

Инфо клиента: вся информация о клиент и его история (что и когда он брал, когда возвращал)
    
    

