<div align="centr">
  <h1>E-shop app</h1>
<!-- Badges -->
<p>
  <a>
<img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/Petrovich-A/E-shop/develop?style=for-the-badge">
  </a>
<a>
<img alt="GitHub commit activity (branch)" src="https://img.shields.io/github/commit-activity/m/Petrovich-A/E-shop/develop?style=for-the-badge">
</a>
<a>
<img alt="GitHub pull requests" src="https://img.shields.io/github/issues-pr/Petrovich-A/E-shop?style=for-the-badge">
</a>
</p>
</div>

<br />

<!-- Table of Contents -->

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
    * [Screenshots](#camera-screenshots)
    * [Tech Stack](#space_invader-tech-stack)
    * [Features](#dart-features)
    * [Run Locally](#running-run-locally)
    * [Database structure](#key-database-structure)
- [Roadmap](#compass-roadmap)
- [Contact](#handshake-contact)
- [Acknowledgements](#gem-acknowledgements)

<!-- About the Project -->

## :star2: About the Project

<!-- Screenshots -->

This Java application is an `E-shop` that allows users to register, authorize, and browse products by category. It utilizes
`Thymeleaf` for UI technology and is built on `Spring Boot`, `Spring MVC`, and new Java 17 technologies. 
Users can add items to their cart for purchase. The system is designed to streamline the online shopping experience
by providing a user-friendly interface and incorporating the latest Java technologies for improved functionality and security.

### :camera: Screenshots

<div> 
<img src="https://github.com/Petrovich-A/E-shop/blob/develop/main_page.png" alt="Alt text" title="Optional title">
</div>

<!-- TechStack -->

### :space_invader: Tech Stack

<details>
  <summary>Show</summary>
  <ul>
    <li><a>Java 17</a></li>
    <li><a>Spring boot</a></li>
    <li><a>Maven 3.8.1</a></li>
    <li><a>Postgresql 42.6.0</a></li>
    <li><a>Lombok 1.18.24</a></li>
    <li><a>Modelmapper 3.1.1</a></li>
  </ul>
</details>

<!-- Features -->

### :dart: Features

- user registration and authorization

<!-- Run Locally -->
### :running: Run Locally

Clone the project

```bash
  git clone https://github.com/Petrovich-A/E-shop.git
```

Go to the project directory and `run` this [script](https://github.com/Petrovich-A/E-shop/blob/develop/src/main/resources/script/create_and_populate_tables)
to populate the database tables.

<!-- Database struct -->
### :key: Database structure

<!-- Roadmap -->
## :compass: roadmap:

* [x] building a plain Application with Spring Boot
* [x] create the User controller
* [x] plug the Hibernate
* [x] connect entities with 1:M and M:M relationships
* [x] add entities validator
* [x] add DTO and converters
* [x] add global search by product name
* [x] add User registration with saving Users to database
* [x] add User authorization
* [x] create shopping cart and opportunity to add products

## :handshake: Contact

Petrovich Alexandr - [@Petrovich Alexandr](https://www.linkedin.com/in/alexandr-petrovich/) - a.piatrovich@gmail.com

<!-- Acknowledgments -->

## :gem: Acknowledgements

Use this section to mention useful resources and libraries that you have used in your projects.

- [Shields.io](https://shields.io/)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [Emoji Cheat Sheet](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md#travel--places)
- [Readme Template](https://github.com/othneildrew/Best-README-Template)