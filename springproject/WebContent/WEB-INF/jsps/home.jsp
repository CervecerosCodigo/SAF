
<%@include file="head.jsp"%>


<h3>Quick overview of the project</h3>
<h4>Introduction</h4>
<p>Over the course of this semester the idea of what Java frameworks are, has changed a lot. Coming from regular Java desktop applications and into this environment has
proven to be very demanding and time consuming, and from being able to make quite good applications, the group has struggled with the fact that there is no way to master
this topic in this short time, and that we have to accept not being able to make a finished product.</p>
<p>Every little thing has taken up time and our previous Java knowledge has not been much help. We are therefore writing about why/how we have worked and our obstacles 
as the work progressed.</p>

<h4>Initial goal</h4>
<p>The group had a goal to learn as much as possible of the frameworks that we were expected to use. 
This didn't change, but spending days trying to make Spring MVC application on JBoss talk to the database on a hosted solution like OpenShift, 
and other obstacles has made us reevaluate how much working functionality we can offer in the given time window.</p>

<h4>What is implemented</h4>
<ul>
	<li>A simple database schema that has at least one functional many-to-one relationship, implemented using Hibernate.
		<ul>
			<li>All POJO entities are configured using Annotations.</li>
			<li>Each Entity has its own Dao-class that handles the Hibernate queries.</li>
			<li>To link Controllers and the database layer together a ServiceLayer was added. The services are autowired into the controllers where they are needed.</li>
			<li>The database is configured using JNDI. Database related XML-configuration can be found in <i>com/cerveceroscodigo/spring/config/dao-context.xml</i></li>
		</ul>
	</li>
	<li>Spring setup - the basics
		<ul>
			<li><i>Web.inf</i> is configured to use ContextListener and it loads the relevant xml-contexts found in <i>com.cerveceroscodigo.spring.config.</i></li>
			<li>The DispatcherServlet <i>/springproject/WebContent/WEB-INF/springproject-servlet.xml</i> maps static resources and uses Component-Scan to scan for Controllers.</li>
		</ul>
	</li>
	<li>Spring Security
		<ul>
			<li>The project is filtering requests using <i>springSecurityFilterChain</i> and it's implementation can be found in 
				<i>src/com/cerveceroscodigo/spring/config/security-context.xml</i></li>
			<li>To make Spring Security work, we had to add a <i>users</i> table and a <i>authorities</i> table to the database schema 
				and use custom database queries to satisfy Spring
				<ul>
					<li>This is not optimal, as these two tables are independent and not "in the loop" and relational</li>
				</ul>
			</li>
			<li>There are currently to roles, <i>ROLE_USER</i> and <i>ROLE_ADMIN</i>. These two are actively used in the jsp's to limit access to resources,
			but also in the <i>security-context.xml</i> to provide the "intercept url patterns"</li>
			<li>Login og Logout functionality is implemented using CSRF - Cross Site Request Forgery</li>
		</ul>
	</li>
	<li>Access levels
		<ul>
			<li>Annonymous
				<ul>
					<li>All visitors can access the products page</li>
					<li>All visitors can register a new account</li>
				</ul>
			</li>
			<li>User/Customer
				<ul>
					<li>At this point, the customer can access his/her own account page and change any information there.</li>
					<li>Order history is not finished, and is therefore not enabled in the users' account page</li>
				</ul>
			</li>
			<li>Admin
				<ul>
					<li>Can list all users currently registered</li>
					<li>Can register new products/items</li>
				</ul>
			</li>
		</ul>
	</li>
	<li>About the implemented jsp's
		<ul>
			<li>The jsp's uses JSTL and Expression Language to iterate over supplied data from Controllers and also to provide conditional tests.</li>
			<li><i>head.jsp</i> and <i>footer.jsp</i> are statically included on every jsp so that updating scripts, css and the top menu is done in one place, in one file.</li>
			<li>Spring forms are used for registration, and for <i>registercustomer.jsp</i> also Spring based validation is done towards the Customer POJO class.</li>
		</ul>
	</li>

</ul>

<h4>Started, but not finished</h4>
<h5>Cart/basket</h5>
<p>The work on this functionality was started a bit late. This kind of functionality requires work in Javascript, with or without Ajax/JSON. 
This is outside the scope of the course, and also touches on things that are not Spring related at all. 
For this reason we have focused on displaying items from the database, and make a "mockup" of how a shopping cart could be implemented given time.</p>

<h5>Hibernate</h5>
<p>Hibernate is a big topic, and again time constraints has constantly made us reevaluate our database schema. It started out with lots of relations and 3NF, 
which would be fine if using regular SQL-queries. Several times we have reduced the complexity of the schema, and as it stands now, 
most of the update and delete functionality is missing from the Hibernate queries</p>
<p>This is also true for Orders and order history. It is very difficult to accept even such a small database to be unfinished with functionality..</p>

<h4>Closing remarks</h4>
<p>The knowledge the group has acquired of both Spring MVC and Hibernate, as well as using (or trying to use) application servers and different hosting services 
has been an exercise in googling. Things that are supposed to be "click and execute" are certainly not so, and not having any reference points to 
previous school projects to draw upon has in a way deterred us as much as the hunger for new knowledge has encouraged us. </p>

<p>As mentioned several times, starting up with this Spring MVC and Hibernate project has been daunting. 
Every group member has spent dozens of hours just being able to get to a certain minimum where we could start working on the project. 
The more we have worked the more we understand that we need much much more time to make what we started out with as original plan and goal.</p>

<p>We hope that our work still has shown that we have understood the concepts of the course and that within the time frame, 
learning and implementing the different aspects of the technologies used in the project, will result in a good evaluation.</p>

<%@include file="footer.jsp"%>
