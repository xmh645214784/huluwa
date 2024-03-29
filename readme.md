# Huluwa

151220131

谢旻晖

*xiemhemail@gmai.com*

## 游戏界面

![](figs/游戏界面1.png)

![](figs/游戏界面2.png)



## 游戏特性

- 每个生物**都有自己的攻击力，攻击频率，生命值**，当敌对生物相遇时，双方的生命值各减对方的攻击力，$\le 0$即为死亡
- 实现了配置文件，调整**游戏参数**（战场大小，葫芦娃、怪物的参数）
- 游戏开局会生成**随机地形**，山/树，阻挡双方前进道路
- 提供游戏**暂停/继续**功能
- 回放游戏可以随时进行，由于我的游戏主界面和回放界面是两个**异步**的窗口。
- 记录与回放：自动以游戏的开始时间建立文件，例如`2018.01.06.14.30.22`，并在其中记录游戏过程。回放时只要选择文件夹即可



## 操作指南

### 设置配置文件

在`./configure.properties`文件中有对战场设置、葫芦娃爷爷妖怪们属性的设置。改变值即可改变对应属性，在程序load这个配置文件时会自动对合法性进行检查。其中比较重要的是战场的格子的宽和长。

<font color="red"> 如果使用mvn打包后的jar运行，则配置文件的路径应为jar文件的目录。</font>

**用户可以按照自己的需求，新建配置文件，下面给出了一个实例。**

```properties
# 战场布置相关
# 战场宽/格  合法范围10~15
NRX=10
# 战场长/格  合法范围10~15
NRY=10
# 初始小妖怪喽喽数目 合法范围0~10
NR_LOLOS=5
# 相遇的距离，当两者间的X轴距离和Y轴距离小于这个常量时，进行交战
# 合法范围0~2
DISTANCE_OF_ENCOUNTER=1

# 战斗属性设置
# 攻击力合法范围0~100
# HP合法范围1~100 （100为满血）

# 葫芦兄弟攻击力
DMG_OF_HULUWA=20
# 葫芦兄弟血量
HP_OF_HULUWA=100
# 爷爷攻击力
DMG_OF_GRANDPA=1
# 爷爷血量
HP_OF_GRANDPA=50

# 蛇精攻击力
DMG_OF_SNAKE=100
# 蛇精血量
HP_OF_SNAKE=100
# 蝎子精攻击力
DMG_OF_SCORPION=10
# 蛇精血量
HP_OF_SCORPION=100
# 小喽喽攻击力
DMG_OF_LOLO=30
# 小喽喽血量
HP_OF_LOLO=20
```

**在找不到配置文件的情况下，程序会自动使用默认配置**

### 键盘操作

**<u>由于在我的界面上已经有了三个按钮，我采用的是点击按钮操作的方式。没有使用键盘操作！！更加直观，方便。</u>**

### 基于图片流的回放

由于多线程的异步性，在实现回放时我的第一个想法就是像录屏软件一样把战斗从开始到结束录制下来。这样就可以完成回放。

我的葫芦娃软件会自动在当前目录下新建一个`records`目录，每次玩游戏，**都会以开始游戏的启动时间**建立一个文件夹，并在其中存放录屏的图片流。

![](figs/records.png)

![](figs/replay.png)

**需要回放时，只需选择这样的包含一堆图片的目录即可。**



### 游戏流程

![](figs/process.png)



## 最精彩的回放：人民币玩家的超爽割草游戏体验

在目录`records/2018.01.06.15.25.00`下，点击回放按钮，选择这个目录，进行回放。

本局游戏中，因为蛇精给我冲了钱，我要让他变强。因此，我赋予了她100攻击力和100血量（满）。

妖怪阵营在先送掉一个蝎子精和一堆小兵的情况下，梦幻开局。只剩下了蛇精和一堆残血二五仔。而正义阵营7个葫芦娃尚在，攻击力只有1的瓜皮爷爷已经去西天了，优势巨大。

![](figs/jc-1.png)

但这时候蛇精出现了，呼呼哈嘿，犹如割草一般，一个人把剩下7个葫芦娃全部秒(mu)杀.

![](figs/jc-2.png)

![](figs/jc-3.png)

**你也想获得这样的游戏体验么？快来充钱吧**

![](figs/cq.jpg)

欢迎各路妖怪充值获得绝佳的游戏体验！

![](figs/alipay.png)

## 代码结构

### 包结构

```
└─main
    ├─java
    │  └─cn
    │      └─xmh	#所有代码文件均在cn.xmh包下（避免冲突）
    │          ├─battleGround #战场相关类
    │          ├─formations   #阵法布置
    │          ├─holders      #可以用来占一个格子的东西，可以是地形
    │		  │	 │			#可以是人，可以是妖怪
    │          │  └─creatures #生物，也是一种holder
    │          │      ├─bad   #妖怪
    │          │      └─good  #好人
    │          ├─position	  #抽象的位置定义和实际的二维位置实现
    │          ├─recorder     #回放功能相关
    │          ├─settings     #读取配置文件
    │          └─view         #ui相关
    └─resources
```

### 类结构

最基本的思想是视图，模型，控制三者分离，这样当我们升级其中的某一种时，比如从一个很平庸的swing显示窗口更换为其他高大上的显示，或是这次从全自动的电脑对电脑打架换成人机对战，改动的代码尽量少。

- 模型
  - 所有生物，地形，
- 视图
  - swing相关的类，均在`cn.xmh.view`下
- 控制
  - BattleGround类，与视图、模型直接交互，读取用户的输入，更新所有模型的数据，通知视图更新、重绘。

具体的，分以下几个重要部分进行阐述。

#### settings相关

package settings的主要职责是读取配置文件，加载各种各样的图。其中`class Settings`用于读取配置文件，`interface ImagesSet`用于加载各种各样的图。这样每个生物所要用到的图都可以从这个接口中获得。

```java
public interface ImagesSet {
    ......
    final Image[] HuluwaImage=new Image[]{
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("1.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("2.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("3.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("4.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("5.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("6.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("7.png")).getImage()
    };
   ......

}
```

#### Holder相关

![](figs/creatures.png)

我定义出了一种可以占一个位置的`Holder`类，他有自己的一张代表图，有占的位置(**此处的位置均为抽象的接口，以便更换实现时改动尽量少的代码**)。

```java
abstract public class Holder{
    protected Image image;
    protected PositionInterface position;
}
```

定义出`Holder`的子类`Creature`生物和`Mountain`山，`Tree`树.其中山和树用来创造地形。

`Creature`生物有一些生物通用的属性和方法，比如攻击力，生命值，改变自己的位置(**仍然是抽象意义上的位置**)，死掉，最关键的是每个生物都是一个线程，所以`Creature`有一个抽象方法`abstract void run()`。

```java
abstract public class Creature extends Holder implements Runnable {
	protected int hp = 0;
	protected int damage = 0;
	public void setPosition(PositionInterface position)
     public void Die()
    abstract void run();
}
```

然后，继而定义出抽象类好人类`Good`，和抽象妖怪类`Monster`,葫芦娃、爷爷、蛇精等等再分别继承自他们。

#### 泛型生物工厂接口

![](figs/creatures.png)

为了生成生物，我使用泛型抽象出一个生物工厂接口`interface CreatureFactoryInterface`，再给出一个具体的实现`CreatureFactory`,用于生成本例中的所有生物。

其中抽象工厂接口的形式如下，他具有一个泛型方法接受一个`Creature`的子类的class反射对象，以及生物初始位置(**也是抽象的**)。

```java
public interface CreatureFactoryInterface {
     <T extends Creature> T createCreature(Class<T> tClass, PositionInterface positionInterface);
}
```

#### 位置相关类

![](figs/position.png)

**我所有的位置均是在抽象意义的位置上进行操作、改变的**，因此当我想从二维平面葫芦娃改变成三维立体葫芦娃或是一维直线对战形葫芦娃，是非常方便的。

我定义了所有位置的接口`interface PositionInterface`,他具有一些广义位置上的特性，比如在这个位置上放一个`holder`,得到坐标,判断另外一个坐标是不是在自己旁边，判断相对位置。

```java
public interface PositionInterface {
    Holder getHolder();
    void setHolder(Holder holder);
    int[] getValue();
    String toString();
    boolean isNear(PositionInterface other);
    int  relativePositionofThis(PositionInterface a);
}
```

同时给出一个二维意义下的实现`class TwoDimePosition`,和二维坐标集合`TwoDimePositionSet`,这个集合中存放了$$N*M$$个位置，并通过`class Settings`读取配置文件来获得$N$和$M$的值进行初始化。

#### 战场相关类

![](figs/battleground.png)

一个战场有哪些要素，无非两者，生物和位置。此外还有一些方便程序编写的方法，比如碰撞检测、得到某个位置上的`Holder`之类的、添加生物、删除生物。

```java
abstract public class BattleGround {
......
  protected static List<PositionInterface> positionInterfaces = TwoDimePositionSet.getPositionInterfaces();
  static protected List<Creature> creatures = Collections.synchronizedList(new ArrayList<Creature>());
  ......
  public abstract void collisionDetection();
  public void addCreatures(Creature... creatures);
  public boolean deleteCreature(Creature target);
}
```

这个类会在实际运行中被多线程同时访问，因为每个生物都要获得战场的状态来判断自己下一步的行动怎么办。为此我将关键的生物和位置队列使用了`Collections.synchronizedList`来保证**线程安全**。

同时我又实现了二维意义下的战场`class TwoDimeBattleGround`，他实现了其中的碰撞检测。

#### Recorder存档相关

这个是回放相关的，由于多线程的异步性，在实现回放时我的第一个想法就是像录屏软件一样把战斗从开始到结束录制下来。这样就可以完成回放。

我使用了`java.awt.Robot`类来获得指定区域的屏幕截图，每隔40ms截一次，依次保存到指定目录下。`class Recorder`本身也是一个`Thread`。

这样，当回放时，我们只需选择包含这样的一张张图片目录即可。

![](figs/replay.png)

回放时也只要将这些图以相同的速率一张张的播放即可。

![](figs/replaying.png)

#### 阵法相关

![](figs/formation.png)

```java
public interface FormationChanger {
    void changFormation(PositionInterface startPos, List<?extends Creature> toBeArrangeCreatures);
}
```

我抽象出阵法的接口，他接受一个阵法布置的起始点，接受一堆要摆放的生物。然后对他们的位置进行arrange.

各种阵形均继承于他。

#### Ui相关

swing相关的设计的比较简单就不提了，有一个定时器会每隔100ms驱动界面进行刷新，刷新时UI从战场类中获得所有现存生物的位置，进行绘制。

各个生物线程在用户使用`暂停`时都会`wait`,直到用户使用`继续`,使用`notifyAll()`进行唤醒。

在swing事件处理时，定义内部类`private class`，通过`父类类名.this`获得父类对象，同时，内部类对外围对象的函数均可调用，但其他类对内部类则无法访问，体现了封装的思想。

#### 总类图

![](figs/whole.png)



## 单元测试

在写葫芦娃碰到的最大的一个BUG就是在移动生物体时，比如从大娃从位置A->位置B，我设置了B位置上的是大娃，大娃的位置是B，但忘记清除A位置上的`holder`。

由于我画面显示的逻辑，我们只根据生物的位置进行绘图，所以导致了我的A位置上一直有一个**隐藏的大娃**，调试了很久才调出来。

为此我专门针对了移动位置相关的函数进行了单元测试。

见`test/java/cn.xmh/`下的两个测试。

**机器永远是对的，未测试的代码永远是错的**



## 设计思想

本程序运用到许多课上所讲的东西，实践证明，确实老师们所讲的是可以帮助我的编码的。具体的来看，包括这样几点：

1. 多用`assert`断言，让错误无从遁形

2. 在swing事件处理时，内部类继承默认Adapter,使用了默认适配器模式，仅重写自己需要的部分。大大简便了代码的编写。

   ```java
   private class TAdapter extends KeyAdapter {
     ......
     @Override
     public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
       if (key == KeyEvent.VK_SPACE) {
         spaceHandle();
       }
     }
   }
   ```

3. 本程序中几乎所有的操作都是在抽象的类/接口上进行操作，满足依赖倒置的设计原则，在更换了某个方面的实现方式时修改的代码会很少，实现了低耦合。

4. 各个生物线程在用户使用`暂停`时都会`wait`,直到用户使用`继续`,使用`notifyAll()`进行唤醒，体现了线程同步的思想。


## 使用的设计模式和体现出的设计原则

设计模式

 -  工厂模式：用于生成新的葫芦娃，爷爷等等生物

    ```java
    public interface CreatureFactoryInterface {
         <T extends Creature> T createCreature(Class<T> tClass, PositionInterface positionInterface);
    }
    ```

 -  单例模式：类设计中诸如战场类，二维位置集合类等等都是单例，方便了代码的编写。

 -  模版模式：战场类留出了一些abstract的方法由子类二维战场类进行具体的实现。这样当二维葫芦娃变成三维葫芦娃时，修改的代码不会很多。低耦合。

 -  默认适配器模式：在写UI事件处理时


设计原则

- 依赖倒置原则：实现基本都依赖于某个抽象的接口，写出足够抽象的代码
- Liskov 替换原则：生物`class Creature`体现的特别明显
- SRP：每个类都尽量只完成一件事
- OCP：模版设计模式，父类有部分抽象方法可供子类实现。子类不重写父类已实现的方法，改变他的行为。





## 不足之处

由于自己水平很差，加之是个拖延症患者。本次大作业还是有许多毛病。比如：

- 由于使用的是录屏回放的方式，一旦葫芦娃软件的界面被其他窗口遮挡，录屏也会显示出被遮挡的样子。
- 由于习惯了C#的拖拽式界面设计，对swing布局的不了解，对idea formDesigner的不熟悉，本次实验采用的`nullLayout`,这导致了用户缩放界面，界面元素不会随之变化，为此。。。。我禁止用户缩放界面.
- 初期设计时很多想法最后由于要连考两门没有时间实现，打算在寒假实现。
  - 从二维葫芦娃升级为三维葫芦娃，或是降维度为一维葫芦娃，体悟一下自己类设计中面向对象还存在的不足之处。是否抽象的不够好，是否存在表面的面向对象，<u>这些都是要实际改动了代码才能知道的</u>。
  - 从基于格子的PPT动画播放，衍生为基于像素的动画播放。减少卡顿。
  - 在本例中，所有的生物都是由电脑自动进行控制的，下一步可以思考能否让玩家参与进这个葫芦娃大战妖精的游戏中。



## 尾声

JAVA程序设计课只会上一学期，但从选择这个专业开始，编程注定会是一生的事，感谢曹老师和余老师的一学期的教导。比心~❤