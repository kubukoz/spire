package spire.example

import spire.implicits._

import java.math.MathContext

import org.apfloat.{Apfloat, ApfloatMath}

object TrigTest {
  val sqrt2String = """1.41421356237309504880168872420969807856967187537694807317667973799073247846210703885038753432764157273501384623091229702492483605585073721264412149709993583141322266592750559275579995050115278206057147010955997160597027453459686201472851741864088919860955232923048430871432145083976260362799525140798968725339654633180882964062061525835239505474575028775996172983557522033753185701135437460340849884716038689997069900481503054402779031645424782306849293691862158057846311159666871301301561856898723723528850926486124949771542183342042856860601468247207714358548741556570696776537202264854470158588016207584749226572260020855844665214583988939443709265918003113882464681570826301005948587040031864803421948972782906410450726368813137398552561173220402450912277002269411275736272804957381089675040183698683684507257993647290607629969413804756548237289971803268024744206292691248590521810044598421505911202494413417285314781058036033710773091828693147101711116839165817268894197587165821521282295184884720896946338628915628827659526351405422676532396946175112916024087155101351504553812875600526314680171274026539694702403005174953188629256313851881634780015693691768818523786840522878376293892143006558695686859645951555016447245098368960368873231143894155766510408839142923381132060524336294853170499157717562285497414389991880217624309652065642118273167262575395947172559346372386322614827426222086711558395999265211762526989175409881593486400834570851814722318142040704265090565323333984364578657967965192672923998753666172159825788602633636178274959942194037777536814262177387991945513972312740668983299898953867288228563786977496625199665835257761989393228453447356947949629521688914854925389047558288345260965240965428893945386466257449275563819644103169798330618520193793849400571563337205480685405758679996701213722394758214263065851322174088323829472876173936474678374319600015921888073478576172522118674904249773669292073110963697216089337086"""

  val piString = """3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132000568127145263560827785771342757789609173637178721468440901224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595024459455346908302642522308253344685035261931188171010003137838752886587533208381420617177669147303598253490428755468731159562863882353787593751957781857780532171226806613001927876611195909216420198938095257201065485863278865936153381827968230301952035301852968995773622599413891249721775283479131515574857242454150695950829533116861727855889075098381754637464939319255060400927701671139009848824012858361603563707660104710181942955596198946767837449448255379774726847104047534646208046684259069491293313677028989152104752162056966024058038150193511253382430035587640247496473263914199272604269922796782354781636009341721641219924586315030286182974555706749838505494588586926995690927210797509302955321165344987202755960236480665499119881834797753566369807426542527862551818417574672890977772793800081647060016145249192173217214772350141441973568548161361157352552133475741849468438523323907394143334547762416862518983569485562099219222184272550254256887671790494601653466804988627232791786085784383827967976681454100953883786360950680064225125205117392984896084128488626945604241965285022210661186306744278622039194945047123713786960956364371917"""

  val eString = """
2.718281828459045235360287471352662497757247093699959574966
967627724076630353547594571382178525166427427466391932003059
921817413596629043572900334295260595630738132328627943490763
233829880753195251019011573834187930702154089149934884167509
244761460668082264800168477411853742345442437107539077744992
069551702761838606261331384583000752044933826560297606737113
200709328709127443747047230696977209310141692836819025515108
657463772111252389784425056953696770785449969967946864454905
987931636889230098793127736178215424999229576351482208269895
193668033182528869398496465105820939239829488793320362509443
117301238197068416140397019837679320683282376464804295311802
328782509819455815301756717361332069811250996181881593041690
351598888519345807273866738589422879228499892086805825749279
610484198444363463244968487560233624827041978623209002160990
235304369941849146314093431738143640546253152096183690888707
016768396424378140592714563549061303107208510383750510115747
704171898610687396965521267154688957035035402123407849819334
321068170121005627880235193033224745015853904730419957777093
503660416997329725088687696640355570716226844716256079882651
787134195124665201030592123667719432527867539855894489697096
409754591856956380236370162112047742722836489613422516445078
""".replace("\n", "")

  val sin1String = """0.84147098480789650665250232163029899962256306079837106567275170999191040439123966894863974354305269585434903790792067429325911892099189888119341032772921240948079195582676660699990776401197840878273256634748480287029865615701796245539489357292467012708648628105338203056137721820386844966776167426623901338275339795676425556547796398976482432869027569642912063005830365152303127825528985326485139819345213597095596206217211481444178105760107567413664805500891672660580414007806239307037187795626128880463608173452465639142025240418776342074920695200771334780981427902145268255663208233521544160916442090589298702247338446044897237139799127408192472504885548731193103506819081515326074573929111833196282150897348688114214528382298651257016673840744551923756143221290605924827397036818015856309054326678464310753126381217325670198560110683602890189501942151616655191791451720046686595971691072197805885406460019940137014053095808552052805253171133230546163836360181699479715004851507939838303956781679481612214022089169871097439312119047662675566086294392071275402640359514268194074251540509760628173824611545461887724013893033097655710720923383300037962223686883701139002878780993189318042589186667350764574871832803213239756083405282545891339670465091692984089498187623312511333175060736346993028447358100792912002026594124151266209525958742511753370874925932543128848095568660510785175825118697437203858230074565789309261792625965989592631713535377491713445692396228047195412288721790125447542029363145846289425733964347592770467557713387870541917263115781222121226362856383693718343896370119485449638235369993727840616908655428824719679100327553408654773047798498160690504887192912540575508660011604308545547565213138521659574660936494093936115860536861156215879156832282926653497877081988977710396568355116845473688431210663348131151930796249191378507466952481158437523193147093207020761166053535064956194324683812502894489863808055125392222817759"""

  val cos1String = """0.54030230586813971740093660744297660373231042061792222767009725538110039477447176451795185608718308934357173116003008909786063376002166345640651226541731858471797116447447949423311792455139325433594351775670289259637573615432754964175449177511513122273010063135707823223677140151746899593667873067422762024507763744067587498161784272021645585111563296889057108124272933169868524714568949043423754330944230240935962395831824547281736640780712434336217481003220271297578822917644683598726994264913443918265694535157507627825138049916073063803172144503498612948833633565577990979301528792788403898009745482510499245379877400614537763713878335942345241681642836188284823748963273905562609120175898275025285999174385806924855842322178268582710882915646830067968759551300361081203367474727491810336735150934588883042032175965940527039347625024873707526613133698424160597105956065999786913844155744144664200128393988709263234533388686262996547097680548368303582118234117324184657718641165142941883264446907838591321108965751039607059607592213323660177863514921082050310656541987948453420177383858113579623540182960011758733767778529012582042590252378015040608508829087950252257443585695220182587686953178630951862635538238927825675180425368743403344841991396417781093684806263611146067539383375942699390337470983257552404763865989773297072016672471265637529003066146050342815638000132821795624516585101709968133096518936641773018068280494218206411004440915664544690557251748204811569948702215998846714179585629415775423880922557518170184026639223302647449153112490406267634437218298620389556930798877002153585167629156936628880939196096008595816389214258978588162439518178516116679337127636809523322140494646659369502108475100203164523792898926651157478006591730621238496237258029892572379314418350587538783099726468237265806227980386286352080779564998904322461650476909172461824130833248917927284977135330033857743802651199515021977369174376834613750086678"""

  def main(args: Array[String]): Unit = {
    testSqrt2()
    //apfloatSqrt2()

    testPi()
    //apfloatPi()

    testE()

    testExp1()
    //apfloatExp1()

    testSin1()
    //apfloatSin1()

    testCos1()
    //apfloatCos1()
  }

  val verbose: Boolean = false
  val check: Boolean = true

  val start: Int = 10
  val limit: Int = 1000

  def apfloatSqrt2(): Unit =
    aptest("sqrt(2)", i => ApfloatMath.sqrt(new Apfloat(2, i)), sqrt2String)
  def apfloatPi(): Unit =
    aptest("pi", i => ApfloatMath.pi(i), piString)
  def apfloatExp1(): Unit =
    aptest("exp(1)", i => ApfloatMath.exp(new Apfloat(1, i)), eString)
  def apfloatSin1(): Unit =
    aptest("sin(1)", i => ApfloatMath.sin(new Apfloat(1, i)), sin1String)
  def apfloatCos1(): Unit =
    aptest("cos(1)", i => ApfloatMath.cos(new Apfloat(1, i)), sin1String)

  def testSqrt2(): Unit =
    test("sqrt(2)", mc => BigDecimal(2, mc).sqrt, sqrt2String)
  def testPi(): Unit =
    test("pi", mc => new spire.std.BigDecimalIsTrig(mc).pi, piString)
  def testE(): Unit =
    test("e", mc => new spire.std.BigDecimalIsTrig(mc).e, eString)
  def testExp1(): Unit =
    test("exp(1)", mc => spire.math.exp(BigDecimal(1, mc)), eString)
  def testSin1(): Unit =
    test("sin(1)", mc => spire.math.sin(BigDecimal(1, mc)), sin1String)
  def testCos1(): Unit =
    test("cos(1)", mc => spire.math.cos(BigDecimal(1, mc)), cos1String)

  def aptest(name: String, f: Int => Apfloat, s: String): Unit = {
    var i = start
    val t0 = System.currentTimeMillis()
    println(s"testing $name")
    while (i < limit) {
      if (verbose) println("  trying i=%s" format i)
      implicit val mc = new MathContext(i)
      val seen = f(i)
      if (check) {
        val want = new Apfloat(s, i)
        val d = if (seen.compareTo(want) < 0)
          want.subtract(seen)
        else
          seen.subtract(want)
        val ulp = ApfloatMath.pow(new Apfloat(10, i), -i)
        if (d.compareTo(ulp) > 0) {
          println(s"failed on i=$i:")
          println(s"  seen=$seen")
          println(s"  want=$want")
          i = 100000
        }
      }
      i += 1
    }
    val t = System.currentTimeMillis() - t0
    println(s"$name took $t ms\n")
  }

  def test(name: String, f: MathContext => BigDecimal, s: String): Unit = {
    var i = start
    val t0 = System.currentTimeMillis()
    println(s"testing $name")
    while (i < limit) {
      if (verbose) println("  trying i=%s" format i)
      implicit val mc = new MathContext(i)
      val seen = f(mc)
      if (check) {
        val want = BigDecimal(s, mc)
        if ((seen - want).abs > seen.ulp) {
          println(s"failed on i=$i:")
          println(s"  seen=$seen")
          println(s"  want=$want")
          i = 100000
        }
      }
      i += 1
    }
    val t = System.currentTimeMillis() - t0
    println(s"$name took $t ms\n")
  }
}
