# language: ru

Функционал: Тестовый пример

  @test_1
  Сценарий: Проверка работы поиска ya.ru
    Когда Пользователь открывает страницу 'ya.ru'
    То Система отображает поле ввода поискового запроса
    Когда Пользователь вводит в поле ввода поискового запроса значение "ocrv.ru"
    И Пользователь нажимает в поле ввода поискового запроса клавишу 'Enter'
    То Система отображает элемент с текстом "ocrv.ru"