# Bloom

<!--- Replace <OWNER> with your Github Username and <REPOSITORY> with the name of your repository. -->
<!--- You can find both of these in the url bar when you open your repository in github. -->
![Workflow result](https://github.com/matsujun/android-dev-challenge-compose_week3_1/workflows/Check/badge.svg)


## :scroll: Description
<!--- Describe your app in one or two sentences -->
Bloom app


## :bulb: Motivation and Context
<!--- Optionally point readers to interesting parts of your submission. -->
<!--- What are you especially proud of? -->
I think the layout is completely same as spec.
But some color, and design of checkbox are looks little bit different.
They are not defined on spec PDF, so I cant set them to completely same design.

* Checkbox on PDF is larger than Checkbox of JetpackCompose.
  * There are no spec of corner radius of checkbox, so I did not use full customized Checkbox
* If I use OutlinedTextField, it has extra space above outline, and it is not same as design spec. So I put TextField inside of outlined Box.
  * But there are no spec about outline.
* There are no spec about height of divider on Home screen.
  * So I just use default height.
## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">&emsp;<img src="/results/screenshot_3.png" width="260">
<img src="/results/screenshot_4.png" width="260">&emsp;<img src="/results/screenshot_5.png" width="260">&emsp;<img src="/results/screenshot_6.png" width="260">


## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```