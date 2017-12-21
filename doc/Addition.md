# Estimation

I think it will take me between one and two hours to complete this new feature. I will have to create a new pane and add observables so that the image updates with the image of the turtle, so I will need to update WorkspacePage and TurtleView.

# Review

It took me about two hours, so I was pretty accurate with my estimation. I did have to update WorkspacePane and TurtleView, as well as TurtleViewer very slightly. I ended up not going the updating with observables because the order in which things happened made it very difficult. The turtle image was getting created before my new pane had added itself as a listener, so I was missing it. Also, we didn't have any listeners/observables in this section of the code, so it didn't make a whole lot of sense to create one from scratch just for this.

I didn't get it completely right on my first try because I forgot that the image string some of the methods were passing was actually a FileInputStream and not a string representing the filepath, so I got all sorts of errors. Also, as mentioned above, my timing was off on the listener implementation that I tried.

# Analysis

I hadn't realized this when I first did the code, but this made me realize that the front-end is a bit messy. We definitely should have commented our code better, and there are a couple methods here and there that got auto-added with an interface and never got filled in. Also, I think there are too many instances of objects getting passed around in the front-end; the encapsulation isn't great. It could definitely be improved by better maintenance. Also, I think some of the classes are extraneous and could maybe have been consolidated into one class. I actually didn't do much front-end work when I did this project, so I wasn't very familiar with this code, and it was still fairly easy to add this feature. In part I think this is because everything is named very well, so it's easy to navigate the classes. Also, the packaging structure is good and it's easy to find stuff.