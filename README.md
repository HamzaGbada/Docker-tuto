<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo_name, twitter_handle, email, project_title, project_description
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
<!-- 
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
-->
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="docker.png" alt="Logo" width="300" height="75">
  </a>

  <h3 align="center">Global concepts of Docker</h3>
<!--
  <p align="center">
    project_description
    <br />
    <a href="https://github.com/github_username/repo_name"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/github_username/repo_name">View Demo</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Report Bug</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Request Feature</a>
  </p>

-->


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#Intoduction">Intoduction</a>
      <!--
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
      -->
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#docker-architecture">Docker Architecture</a>
              <ul>
        <li><a href="#docker-daemon">Docker Daemon</a></li>
        <li><a href="#docker-client">Docker Client</a></li>
        <li><a href="#docker-registries">Docker registries</a></li>
        <li><a href="#docker-objects">Docker Objects</a></li>
      </ul></li>
    <li><a href="#images-vs-containers">Images VS Containers</a></li>
    <li><a href="#docker-commands">Docker Commands</a></li>
    <li><a href="#dockerfile-vs-docker-compose">Dockerfile VS Docker Compose</a>
          <ul>
        <li><a href="#dockerfile">Dockerfile</a></li>
        <li><a href="#docker-compose">Docker Compose</a></li>
      </ul>
    </li>
    <li><a href="#docker-storage-and-networking">Docker Storage and Networking</a>
              <ul>
        <li><a href="#docker-storage">Docker Storage</a></li>
        <li><a href="#ocker-networking">Docker Networking</a></li>
      </ul>
     </li>
      <li><a href="#projets">Projects</a>
              <ul>
        <li><a href="#spring-boot-demo">Spring-Boot Demo</a></li>
        <li><a href="#nodejs-demo">NodeJs Demo</a></li>
        <li><a href="#jupyter-notebook-demo">Jupyter-Notebook Demo</a></li>
      </ul>
     </li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#references">References</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Introduction

**Docker** is an open platform for developers and sysadmins to build, ship, and run distributed applications, whether on laptops, data center VMs, or the cloud.
Personally, I think that Docker became nowadays a main skill like Linux ans programming that everyone working in Computer Science field should know.
So, I write this course in order to introduce Docker to beginners.

<!-- GETTING STARTED -->
## Getting Started

Before we start, I recommend readers to use linux in this course.

### Prerequisites

What you should know before starting:
1. Linux Basics
2. Understand the basics of web and database servers (Not mandatory).

### Installation
This is an installation guide of Docker into a Debian distribution (Ubuntu, Linux Mint, ...), if you have another distribution installed in you laptop check the [official documentation](https://docs.docker.com/engine/install/) 
1. Update the apt package index and install packages to allow apt to use a repository over HTTPS:
   ```sh
   $ sudo apt-get update
   $ sudo apt-get install \
        apt-transport-https \
        ca-certificates \
        curl \
        gnupg \
        lsb-release
   ```
2. Add Docker’s official GPG key:
   ```sh
    $ curl -fsSL https://download.docker.com/linux/debian/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
   ```
3. Add Docker’s official GPG key:
   ```sh
    $ echo \
        "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian \
        $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
   ```
4. Update the apt package index, and install the latest version of Docker Engine and containerd:
   ```sh
    $ sudo apt-get update
    $ sudo apt-get install docker-ce docker-ce-cli containerd.io
    ```
5. Enable Docker for non-root user:
   ```sh
    $ sudo groupadd docker
    $ sudo usermod -aG docker $USER
    ```
   Log out and log back in so that your group membership is re-evaluated
   ```sh
    $ newgrp docker 
    $ sudo systemctl restart docker
    $ sudo systemctl enable docker
    ```
6. Verify that Docker Engine is installed correctly.
   ```sh
    $ docker run hello-world
    ```
(This command downloads a test image and runs it in a container. When the container runs, it prints a message and exits.)
<!-- Docker Architecture -->
## Docker Architecture
Docker uses the client-server architecture, where each Docker client communicate the the Docker daemon using a REST API, over UNIX
sockets or a network interface. They can run on the same system or the client can connect the daemon remotely.
![alt text](img/architecture.svg)
### Docker Daemon
### Docker Client
### Docker registries
### Docker objects
<!-- Images VS Containers -->
## Images VS Containers

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_



<!-- Docker Commands -->
## Docker Commands

See the [open issues](https://github.com/github_username/repo_name/issues) for a list of proposed features (and known issues).



<!-- Dockerfile VS Docker Compose -->
## Dockerfile VS Docker Compose

### Dockerfile
sdjflskd
### Docker Compose


<!-- Docker Storage and Docker Networking -->
## Docker Storage and Docker Networking

### Docker Storage
sdjflskd
### Docker Networking

Samir Samir

<!-- Projects -->
## Projects

### Spring-boot Demo
sdjflskd

### NodeJS Demo

Samir Samir

### Jupyter-notebook Demo

Samir Samir
<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [@twitter_handle](https://twitter.com/twitter_handle) - email

Project Link: [https://github.com/github_username/repo_name](https://github.com/github_username/repo_name)



<!-- references -->
## References

* [Docker](https://docs.docker.com/)
* [Playing with Java Microservices on Kubernetes and OpenShift](https://www.amazon.fr/Playing-Java-Microservices-Kubernetes-OpenShift/dp/1796877247)





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[license-shield]: https://img.shields.io/github/license/github_username/repo.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/hamzagbada/
