## :CM: User Onboarding Service

>  This service is an add-on to the CM to onboard patients/users who can not self service to get registered or linked 

## :muscle: Motivation

> The customer may designate an HIU as the recipient of the Health Information when
> requesting consent artifact creation to consent manager. The HIU needs to maintain the
> customer’s health information provided to it securely in compliance with terms of the
> consent granted by the Customer.

## Build Status


## :+1: Code Style

[JAVA Naming Conventions](https://google.github.io/styleguide/javaguide.html)

## :tada: Language/Frameworks

-   [spring webflux](https://docs.microsoft.com/en-us/aspnet/core/?view=aspnetcore-3.1)
-   [Easy Random](https://github.com/j-easy/easy-random)
-   [Vavr](https://www.vavr.io/vavr-docs/)

## :checkered_flag: Requirements

-   [docker >= 19.03.5](https://www.docker.com/)

## :whale: Running From The Docker Image

Create docker image

```
docker build -t uos .
```

To run the image

```
docker run -d -p 9060:8080 uos
```

## :rocket: Running From Source
To run

```
./gradlew bootRun
```

or if you want to run in dev environment setup
```
./gradlew bootRun --args='--spring.profiles.active=dev'
```

## Running The Tests

To run the tests
```
./gradlew test
```

## Features

1.  APIs for registration and linking of users/patients to hospitals

## API Contract

Once ran the application, navigate to

```alpha
{HOST}/index.html
```
