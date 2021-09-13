[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="docker.png" alt="Logo" width="300" height="75">
  </a>

  <h3 align="center">Global concepts of Docker</h3>



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
    <li><a href="#images-vs-containers">Images VS Containers</a>
              <ul>
        <li><a href="#images">Images</a></li>
        <li><a href="#containers">Containers</a></li>
      </ul></li>
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
The Docker daemon `dockerd` listens for Docker API requests and manages Docker objects such as images, containers, networks, and volumes. A daemon can also communicate with other daemons to manage Docker services.
### Docker Client
The Docker client `docker` is the primary way that many Docker users interact with Docker. When you use commands such as `docker run`, the client sends these commands to `dockerd`, which carries them out. The `docker` command uses the Docker API. The Docker client can communicate with more than one daemon.
### Docker registries
A Docker registry stores Docker images. Docker Hub is a public registry that anyone can use, and Docker is configured to look for images on Docker Hub by default. You can even run your own private registry.

When you use the `docker pull` or `docker run commands`, the required images are pulled from your configured registry. When you use the `docker push` command, your image is pushed to your configured registry.
### Docker objects
When you use Docker, you are creating and using images, containers, networks, volumes, plugins, and other objects. This section is a brief overview of some of those objects.
<!-- Images VS Containers -->
## Images VS Containers

Images and Containers are main concepts of in Docker, it's mandatory to difference between them:
### Images
Docker image is like VM image, it's package or a template with instructions for creating a Docker container.
Often, an image is based on another image, with some additional customization. For example, you may build an image which is based on the `ubuntu` image, but installs the Apache web server and your application, as well as the configuration details needed to make your application run
You might create your own images or you might only use those created by others and published in a registry. To build your own image, you create a Dockerfile with a simple syntax for defining the steps needed to create the image and run it. Each instruction in a Dockerfile creates a layer in the image. When you change the Dockerfile and rebuild the image, only those layers which have changed are rebuilt. This is part of what makes images so lightweight, small, and fast, when compared to other virtualization technologies.
### Containers
Containers are completely isolated environment as they can have their own process or service, networking interfaces, mounts..., just like VM except they all share the same operating system kernel.
![alt text](img/container.png)
You can create, start, stop, move, or delete a container using the Docker API or CLI.
By default, a container is relatively well isolated from other containers and its host machine. You can control how isolated a container’s network, storage, or other underlying subsystems are from other containers or from the host machine.

A container is defined by its image as well as any configuration options you provide to it when you create or start it. When a container is removed, any changes to its state that are not stored in persistent storage disappear.


<!-- Docker Commands -->
## Docker Commands
In this section we will introduce all the basics commands:
* Pull command: this command is used to download an image from _dockerhub_.
    ``` 
    $ docker pull <ImageTag> 
    ```
  Example:
    ``` 
    $ docker pull ubuntu 
    ```
* Run command: is used to run a container from an image, running this command will run an instance of the image on the docker host. If the image doesn't exist locally, the docker run command will pull it from the _dockerhub_.
    ```
    $ docker run <imageTag>
    ``` 
    Example:
    ``` 
    $ docker run ubuntu --name ubuntuTest
    ```
* Ps command: Show information about the running containers.
    ```
    $ docker ps 
    ```
    To show information about all containers running or not.
    ``` 
    $ docker ps -a
    ```
    To show information about docker images.
    ``` 
    $ docker images 
    ```  
* Stop Command:
    To stop a running container
    ``` 
    $ docker stop <Container name or ID> 
    ```
    Example:
    ``` 
    $ docker stop ubuntuTest 
    ```
 * Remove Command:
    To remove a container. Note, you should stop the container before removing it.
    ``` 
    $ docker rm <Container name or ID> 
    ``` 
     Example:
    ``` 
    $ docker rm ubuntuTest 
    ```
   To remove an image, you must remove all it dependent containers.
   * Stop Command:
    To stop a running container
    ``` 
    $ docker rmi <Image name or ID> 
    ``` 
     Example:
    ``` 
    $ docker rmi ubuntu 
    ```
 * Execute Command: it execute a linux command inside a docker container.
    ``` 
    $ docker exec <Container name or ID> <linux command> 
    ```
     Example:
    ``` 
    $ docker exec ubuntuTest cat /etc/*release* 
    ```
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
