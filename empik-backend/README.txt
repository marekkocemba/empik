
Dzien Dobry

Załozyłem dwa przypadki użycia

- uruchomienie deweloperskie
- uruchomienie produkcyjne

URUCHOMIENIE DEWELOPERSKIE

Do konteneryzacji i orkiestracji, uzyty został w tym projekcie docker compose. Nasza backendowa aplikacja to empik-backend uruchamiamy ją standardowo przez Intelidea.
Najpierw jednak trzeba uruchomić bazę danych (postgres) można ją postawić lokalnie tak aby credentiale sie zgadzały

	url: jdbc:postgresql://localhost:5432/empik_db
    username: postgres
    password: postgres

Przygotowałem jednak plik docker-compose pod katalogiem ...empik\cicd\postgres, który umożliwia zbudowanie obrazu z postgresem.
Aby to zrobić należy wykonać:

docker-compose build

nastepnie docker-compose up

Zbudowany obraz będzie zawierał Keycloaka, jednak jest on nie podłączony, wyjaśnienie dlaczego tak zawarłem w uruchomieniu produkcyjnym.

URUCHOMIENIE PRODUKCYJNE

No dobrze, prawie produkcyjne. Podarowałem sobie certyfikaty a także zabespieczenie endpointów Keycloakiem mimo że jest skonfigurowany i wstaje razem z innymi komponentami.
Decyzję taką a nie inną podjąłem ponieważ doszedłem do wniosku że te rozwiązania mogą być irytujące podczas sprawdzania rozwiązania. Obraz skonfigurowanego keycloaka  nie usunąłem,
po to aby pokazać że jednak coś umiem.

Uruchomienie, docker-compose pod katalogiem ...empik\cicd, który umożliwia zbudowanie obrazu z endendem, enginxem, postgresem i keycloakiem.
Wszystko jest skonfigurowane do komunikacji po wewnetrznej sieci dokera.
Planowąem postawić 2 node-y backendu. Niestety przez Liquibase, miał miejsce wyścig wątków, raz uruchamiał się drugi node a raz nie.
Rozwiązaniem na przyszłość może być wyciągnięcie Liquibase i tworzenie skryptów do osobnego obrazu, nie mniej po to uzyłem nginx-a aby wprowadzić podstawowy load-balanceing
Load balanding jest skonfigurowany w oparciu o jeden node, troche sztuka dla sztuki.

endpointy:

http://localhost/swagger-ui/index.html


Pozdrawiam Marek Kocemba
