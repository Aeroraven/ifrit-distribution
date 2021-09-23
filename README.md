## ifrit-distribution
Java packages to help render and animate stuffs on consoles. This repository only contains distributed JAR files.<br/>
<s>Deals AOE Arts Damage in a long line</s>

#### To Get Started

<b>For Java 9+ Users</b>

```java
requires com.aeroraven.ifrit;
```

<b>For Non-WinOS Users</b>

- Re-compile IfritNative

  

<b>Initialize the application</b>

This completes localization and operating system adaptation.

```java
IfritApplication app = IfritApplication.createApplication();
```

<b>Create a scene</b>

Scene is an special instance containing components. There's only one scene can be rendered every moment.

```java
IfritScene  scene = new IfritScene();
```

<b>Create a component</b>

A component is a collection of primitives to be rendered. Use `IfritShapeFactory` to create primitives and add them to components via `addPrimitive` method.

```java
IfritSprite sprite = new IfritSprite();
IfritShapeFactory shapeFactory = new IfritShapeFactory();

shapeFactory.textBuilder()
    .setBackColor(255, 0, 0)
    .setForeColor(255,255, 255)
    .createTextWithRectBorder("Button A", 0, 0, 12, 5, 0)
    .store();
sprite.addPrimitive(shapeFactory.getFinalShape(),0);	
```

<b>Set Active Scene</b>

```java
app.setRenderScene(scene);
```



#### Design Patterns Used

- Singleton
- Bridge
- Command
- Mediator
- Factory Method
- Template Method
- Composite
- Observer



#### Shapes Available

- Text Builder / createTextWithRectBorder

- Text Builder / createTextContainer

- Image Builder / createImageContainer

- Primitive Builder / createLine

- Primitive Builder / createCircleArc

- Primitive Builder / createRound

- Primitive Builder / createTriangle

- Primitive Builder / createHollowPolygon

- Primitive Builder / createSolidPolygon

- Primitive Builder / createHollowRectangle

- Primitive Builder / createSolidRectangle

  

#### Commands Available

- Threading Mediator / IfritCPSwitchRenderScene(IfritScene scene)
  - Set the active scene to be rendered
- Threading Mediator / IfritCPAddIOEventHandler(String hash, IfritEventHandler handler)
  - Once IO Thread receives keyboard input signal, the event handler will be called

- Threading Mediator / IfritCPRemoveIOEventHandler(String hash)
  - Remove event handler from IO Thread's hash map
- Threading Mediator / IfritCPAddRenderEventHandler(String hash, IfritEventHandler handler)
  - Once rendering thread updates the frame, the event handler will be called
- Threading Mediator / IfritCPRemoveRenderEventHandler(String hash, IfritEventHandler handler)
  - Remove event handler from Rendering Thread's hash map

