<a name="readme-top"></a>
<!-- PROJECT SHIELDS -->
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h1 align="center">Progamming Fundimentals & Web-Dev Assignment</h1>
  <img src="readme/images/weathertop.png" alt="Logo">  
</div>
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#developed-with">Developed With</a></li>
        <li><a href="#styled-with">Styled With</a></li>
      </ul>
    </li>
    <li>
      <a href="#features">Features</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
WeatherTop Inc. produce a modular weather station called the WeatherTop 1000. This lowcost device takes a set of meteorological readings and displays these on a simple LCD display. WeatherTop Inc. are seeking a Web companion application for the device. This document outlines my submission for this Assignment.
| Developed With| Styled With | 
| :----:        |    :----:   |
| <img src="readme/images/play-logo.png" style="height: 200px;">    | <img src="readme/images/bulma-logo.png">       |
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- FEATURES -->
## User Accounts
<img align="left" width="70%" src="readme/images/user-accounts.gif" style="max-width: 95%;vertical-align:middle;margin:50px 0px"> 

### Account Features
- [x] Sign up and Login (both with Form Validation)
- [x] Loading from the data.yml
    - [x] Users 
    - [x] User Associated Stations
    - [x] User Associated Readings   
- [x] Profile
    - [x] Edit/Update Account
    - [x] Delete Account
<p align="right">(<a href="#readme-top">back to top</a>)</p>
<br>

## Stations
<img align="left" width="70%" src="readme/images/user-stations.gif" style="max-width: 95%;vertical-align:middle;margin:50px 0px"> 

### Station Features
- [x] Create Station
    - [x] Name 
    - [x] Longitude
    - [x] Latitude  
- [x] Delete Station
- [x] Station Displays
    - [x] Latest weather with SVG moving icons/images
    - [x] Temperature in Celsius & Fahrienheit
    - [x] Wind in km.hr & Bft (Beaufort)    
    - [x] Pressure in hPa
 - [x] Weather Min/Max Readings
 - [x] Weatehr Trends
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Readings
[![Features Account Screen Shot][features-account]](https://weathertop.cleverapps.io/signup)
### Reading Features
- [x] Create 
    - [x] Date/Time
    - [x] Code 
    - [x] Temperature
    - [x] Wind Speed  
    - [x] Pressure
- [x] Edit/Delete Readings
- [x] Station Displays
    - [x] Latest weather
    - [x] Temperature in Celsius & Fahrienheit
    - [x] Wind in km.hr & Bft (Beaufort)    
    - [x] Pressure in hPa
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/github_username/repo_name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Feature 1
- [ ] Feature 2
- [ ] Feature 3
    - [ ] Nested Feature

See the [open issues](https://github.com/github_username/repo_name/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - Kieron Garvey

Project Link: [https://github.com/ki321g/WeatherTOP/](hhttps://github.com/ki321g/WeatherTOP/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>

[![Product Name Screen Shot][product-screenshot]](https://weathertop.cleverapps.io/)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[product-screenshot]: readme/images/weathertop.gif
[features-account]: readme/images/weathertop_user.gif
[Play]: readme/images/play-logo.png
[Play-url]: https://www.playframework.com/
[Bulma]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[Bulma-url]: readme/images/bulma-logo.png
