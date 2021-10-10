<h1 align="center">
<br/>
Froyout UI
</h1>
<p align="center">
  <a href="https://github.com/RezaRamadhanIrianto/froyout-ui/stargazers">
    <img src="https://img.shields.io/badge/Say%20Thanks-👍-1EAEDB.svg" alt="Say thanks">
  </a>
  <a href="https://jitpack.io/#RezaRamadhanIrianto/froyout-ui">
    <img src="https://jitpack.io/v/RezaRamadhanIrianto/froyout-ui.svg" alt="Version"/>
  </a>
</p>

### An Android UI Library Based On My Needs
Why name is Froyout? I hope this library will work from Froyo OS.

### Future
- Relative Rounded Layout 
- Linear Rounded Layout 
- Original Rounded Layout 

### Feature
- Constraint Rounded Layout 

### If Error
> Add 
```manifest
tools:replace="android:theme"
```

### How To Implement
> Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
  ```
  > Step 2. Add the dependency
  ```gradle
dependencies {
	implementation 'com.github.RezaRamadhanIrianto:froyout-ui:newest_version'
}
  ```
