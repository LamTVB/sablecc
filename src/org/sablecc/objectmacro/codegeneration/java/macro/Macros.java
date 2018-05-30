/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;
import java.util.*;

public class Macros{
    private VERSIONS version;

    public Macros(
            VERSIONS version){

        if(version == null){
            throw ObjectMacroException.versionNull();
        }

        this.version = version;
    }

    public Macros(){
        this.version = null;
    }
    
    public MHeader newHeader(){
        MHeader mHeader;
    
        mHeader = new MHeader(this);
    
        return mHeader;
    }
    
    public MPackageDeclaration newPackageDeclaration(String pPackageName){
        MPackageDeclaration mPackageDeclaration;
    
        mPackageDeclaration = new MPackageDeclaration(pPackageName, this);
    
        return mPackageDeclaration;
    }
    
    public MImportJavaUtil newImportJavaUtil(){
        MImportJavaUtil mImportJavaUtil;
    
        mImportJavaUtil = new MImportJavaUtil(this);
    
        return mImportJavaUtil;
    }
    
    public MContext newContext(){
        MContext mContext;
    
        mContext = new MContext(this);
    
        return mContext;
    }
    
    public MInternalsInitializer newInternalsInitializer(){
        MInternalsInitializer mInternalsInitializer;
    
        mInternalsInitializer = new MInternalsInitializer(this);
    
        return mInternalsInitializer;
    }
    
    public MParentInternalsSetter newParentInternalsSetter(String pName){
        MParentInternalsSetter mParentInternalsSetter;
    
        mParentInternalsSetter = new MParentInternalsSetter(pName, this);
    
        return mParentInternalsSetter;
    }
    
    public MCycleDetectorClass newCycleDetectorClass(){
        MCycleDetectorClass mCycleDetectorClass;
    
        mCycleDetectorClass = new MCycleDetectorClass(this);
    
        return mCycleDetectorClass;
    }
    
    public MSuperMacro newSuperMacro(){
        MSuperMacro mSuperMacro;
    
        mSuperMacro = new MSuperMacro(this);
    
        return mSuperMacro;
    }
    
    public MSuperDirective newSuperDirective(){
        MSuperDirective mSuperDirective;
    
        mSuperDirective = new MSuperDirective(this);
    
        return mSuperDirective;
    }
    
    public MClassValue newClassValue(){
        MClassValue mClassValue;
    
        mClassValue = new MClassValue(this);
    
        return mClassValue;
    }
    
    public MClassMacroValue newClassMacroValue(){
        MClassMacroValue mClassMacroValue;
    
        mClassMacroValue = new MClassMacroValue(this);
    
        return mClassMacroValue;
    }
    
    public MClassStringValue newClassStringValue(){
        MClassStringValue mClassStringValue;
    
        mClassStringValue = new MClassStringValue(this);
    
        return mClassStringValue;
    }
    
    public MClassCacheBuilder newClassCacheBuilder(){
        MClassCacheBuilder mClassCacheBuilder;
    
        mClassCacheBuilder = new MClassCacheBuilder(this);
    
        return mClassCacheBuilder;
    }
    
    public MVersionEnumeration newVersionEnumeration(){
        MVersionEnumeration mVersionEnumeration;
    
        mVersionEnumeration = new MVersionEnumeration(this);
    
        return mVersionEnumeration;
    }
    
    public MMacroFactory newMacroFactory(){
        MMacroFactory mMacroFactory;
    
        mMacroFactory = new MMacroFactory(this);
    
        return mMacroFactory;
    }
    
    public MMacroCreatorMethod newMacroCreatorMethod(String pClassName){
        MMacroCreatorMethod mMacroCreatorMethod;
    
        mMacroCreatorMethod = new MMacroCreatorMethod(pClassName, this);
    
        return mMacroCreatorMethod;
    }
    
    public MSwitchVersion newSwitchVersion(){
        MSwitchVersion mSwitchVersion;
    
        mSwitchVersion = new MSwitchVersion(this);
    
        return mSwitchVersion;
    }
    
    public MMacroCaseInit newMacroCaseInit(String pVersion, String pVersionClassName){
        MMacroCaseInit mMacroCaseInit;
    
        mMacroCaseInit = new MMacroCaseInit(pVersion, pVersionClassName, this);
    
        return mMacroCaseInit;
    }
    
    public MVersion newVersion(String pDefaultCase){
        MVersion mVersion;
    
        mVersion = new MVersion(pDefaultCase, this);
    
        return mVersion;
    }
    
    public MMacro newMacro(String pClassName, String pParentClass){
        MMacro mMacro;
    
        mMacro = new MMacro(pClassName, pParentClass, this);
    
        return mMacro;
    }
    
    public MAppliedVersion newAppliedVersion(){
        MAppliedVersion mAppliedVersion;
    
        mAppliedVersion = new MAppliedVersion(this);
    
        return mAppliedVersion;
    }
    
    public MConstructor newConstructor(){
        MConstructor mConstructor;
    
        mConstructor = new MConstructor(this);
    
        return mConstructor;
    }
    
    public MInitInternal newInitInternal(String pName){
        MInitInternal mInitInternal;
    
        mInitInternal = new MInitInternal(pName, this);
    
        return mInitInternal;
    }
    
    public MInitParam newInitParam(String pName){
        MInitParam mInitParam;
    
        mInitParam = new MInitParam(pName, this);
    
        return mInitParam;
    }
    
    public MInitMacroValue newInitMacroValue(String pParamName){
        MInitMacroValue mInitMacroValue;
    
        mInitMacroValue = new MInitMacroValue(pParamName, this);
    
        return mInitMacroValue;
    }
    
    public MInitStringValue newInitStringValue(String pParamName){
        MInitStringValue mInitStringValue;
    
        mInitStringValue = new MInitStringValue(pParamName, this);
    
        return mInitStringValue;
    }
    
    public MSetMacrosCall newSetMacrosCall(){
        MSetMacrosCall mSetMacrosCall;
    
        mSetMacrosCall = new MSetMacrosCall(this);
    
        return mSetMacrosCall;
    }
    
    public MSuperCall newSuperCall(){
        MSuperCall mSuperCall;
    
        mSuperCall = new MSuperCall(this);
    
        return mSuperCall;
    }
    
    public MSingleMacroAdd newSingleMacroAdd(String pReferencedMacroName, String pParamName){
        MSingleMacroAdd mSingleMacroAdd;
    
        mSingleMacroAdd = new MSingleMacroAdd(pReferencedMacroName, pParamName, this);
    
        return mSingleMacroAdd;
    }
    
    public MSingleStringAdd newSingleStringAdd(String pParamName){
        MSingleStringAdd mSingleStringAdd;
    
        mSingleStringAdd = new MSingleStringAdd(pParamName, this);
    
        return mSingleStringAdd;
    }
    
    public MAddAllMacro newAddAllMacro(String pParamName){
        MAddAllMacro mAddAllMacro;
    
        mAddAllMacro = new MAddAllMacro(pParamName, this);
    
        return mAddAllMacro;
    }
    
    public MAddAllString newAddAllString(String pParamName){
        MAddAllString mAddAllString;
    
        mAddAllString = new MAddAllString(pParamName, this);
    
        return mAddAllString;
    }
    
    public MTypeVerifier newTypeVerifier(String pParamName){
        MTypeVerifier mTypeVerifier;
    
        mTypeVerifier = new MTypeVerifier(pParamName, this);
    
        return mTypeVerifier;
    }
    
    public MAbstractTypeVerifier newAbstractTypeVerifier(String pParamName){
        MAbstractTypeVerifier mAbstractTypeVerifier;
    
        mAbstractTypeVerifier = new MAbstractTypeVerifier(pParamName, this);
    
        return mAbstractTypeVerifier;
    }
    
    public MFactoryComparison newFactoryComparison(){
        MFactoryComparison mFactoryComparison;
    
        mFactoryComparison = new MFactoryComparison(this);
    
        return mFactoryComparison;
    }
    
    public MIsBuilt newIsBuilt(){
        MIsBuilt mIsBuilt;
    
        mIsBuilt = new MIsBuilt(this);
    
        return mIsBuilt;
    }
    
    public MParamMacroRefBuilder newParamMacroRefBuilder(String pName){
        MParamMacroRefBuilder mParamMacroRefBuilder;
    
        mParamMacroRefBuilder = new MParamMacroRefBuilder(pName, this);
    
        return mParamMacroRefBuilder;
    }
    
    public MInternalMacroRefBuilder newInternalMacroRefBuilder(String pInternalName){
        MInternalMacroRefBuilder mInternalMacroRefBuilder;
    
        mInternalMacroRefBuilder = new MInternalMacroRefBuilder(pInternalName, this);
    
        return mInternalMacroRefBuilder;
    }
    
    public MInternalMacroSetter newInternalMacroSetter(String pParamName){
        MInternalMacroSetter mInternalMacroSetter;
    
        mInternalMacroSetter = new MInternalMacroSetter(pParamName, this);
    
        return mInternalMacroSetter;
    }
    
    public MParamMacroRef newParamMacroRef(String pName){
        MParamMacroRef mParamMacroRef;
    
        mParamMacroRef = new MParamMacroRef(pName, this);
    
        return mParamMacroRef;
    }
    
    public MInternalMacroRef newInternalMacroRef(String pParamName){
        MInternalMacroRef mInternalMacroRef;
    
        mInternalMacroRef = new MInternalMacroRef(pParamName, this);
    
        return mInternalMacroRef;
    }
    
    public MParamStringRef newParamStringRef(String pName){
        MParamStringRef mParamStringRef;
    
        mParamStringRef = new MParamStringRef(pName, this);
    
        return mParamStringRef;
    }
    
    public MParamStringRefBuilder newParamStringRefBuilder(String pName){
        MParamStringRefBuilder mParamStringRefBuilder;
    
        mParamStringRefBuilder = new MParamStringRefBuilder(pName, this);
    
        return mParamStringRefBuilder;
    }
    
    public MInternalStringRef newInternalStringRef(String pName){
        MInternalStringRef mInternalStringRef;
    
        mInternalStringRef = new MInternalStringRef(pName, this);
    
        return mInternalStringRef;
    }
    
    public MInternalStringRefBuilder newInternalStringRefBuilder(String pInternalName){
        MInternalStringRefBuilder mInternalStringRefBuilder;
    
        mInternalStringRefBuilder = new MInternalStringRefBuilder(pInternalName, this);
    
        return mInternalStringRefBuilder;
    }
    
    public MInternalStringSetter newInternalStringSetter(String pName){
        MInternalStringSetter mInternalStringSetter;
    
        mInternalStringSetter = new MInternalStringSetter(pName, this);
    
        return mInternalStringSetter;
    }
    
    public MInitInternalsMethod newInitInternalsMethod(String pParamName){
        MInitInternalsMethod mInitInternalsMethod;
    
        mInitInternalsMethod = new MInitInternalsMethod(pParamName, this);
    
        return mInitInternalsMethod;
    }
    
    public MInitDirectives newInitDirectives(String pParamName){
        MInitDirectives mInitDirectives;
    
        mInitDirectives = new MInitDirectives(pParamName, this);
    
        return mInitDirectives;
    }
    
    public MNewDirective newNewDirective(String pDirectiveName, String pIndexBuilder){
        MNewDirective mNewDirective;
    
        mNewDirective = new MNewDirective(pDirectiveName, pIndexBuilder, this);
    
        return mNewDirective;
    }
    
    public MSetMacrosMethod newSetMacrosMethod(){
        MSetMacrosMethod mSetMacrosMethod;
    
        mSetMacrosMethod = new MSetMacrosMethod(this);
    
        return mSetMacrosMethod;
    }
    
    public MMacroBuilder newMacroBuilder(){
        MMacroBuilder mMacroBuilder;
    
        mMacroBuilder = new MMacroBuilder(this);
    
        return mMacroBuilder;
    }
    
    public MInitDirectiveCall newInitDirectiveCall(String pParamName){
        MInitDirectiveCall mInitDirectiveCall;
    
        mInitDirectiveCall = new MInitDirectiveCall(pParamName, this);
    
        return mInitDirectiveCall;
    }
    
    public MInitInternalsCall newInitInternalsCall(String pParamName){
        MInitInternalsCall mInitInternalsCall;
    
        mInitInternalsCall = new MInitInternalsCall(pParamName, this);
    
        return mInitInternalsCall;
    }
    
    public MAbstractBuilder newAbstractBuilder(){
        MAbstractBuilder mAbstractBuilder;
    
        mAbstractBuilder = new MAbstractBuilder(this);
    
        return mAbstractBuilder;
    }
    
    public MEmptyBuilderWithContext newEmptyBuilderWithContext(){
        MEmptyBuilderWithContext mEmptyBuilderWithContext;
    
        mEmptyBuilderWithContext = new MEmptyBuilderWithContext(this);
    
        return mEmptyBuilderWithContext;
    }
    
    public MContextCacheBuilder newContextCacheBuilder(){
        MContextCacheBuilder mContextCacheBuilder;
    
        mContextCacheBuilder = new MContextCacheBuilder(this);
    
        return mContextCacheBuilder;
    }
    
    public MNewCacheBuilder newNewCacheBuilder(){
        MNewCacheBuilder mNewCacheBuilder;
    
        mNewCacheBuilder = new MNewCacheBuilder(this);
    
        return mNewCacheBuilder;
    }
    
    public MRedefinedApplyInitializer newRedefinedApplyInitializer(){
        MRedefinedApplyInitializer mRedefinedApplyInitializer;
    
        mRedefinedApplyInitializer = new MRedefinedApplyInitializer(this);
    
        return mRedefinedApplyInitializer;
    }
    
    public MParamMacroField newParamMacroField(String pParamName){
        MParamMacroField mParamMacroField;
    
        mParamMacroField = new MParamMacroField(pParamName, this);
    
        return mParamMacroField;
    }
    
    public MParamStringField newParamStringField(String pParamName){
        MParamStringField mParamStringField;
    
        mParamStringField = new MParamStringField(pParamName, this);
    
        return mParamStringField;
    }
    
    public MInternalMacroField newInternalMacroField(String pName){
        MInternalMacroField mInternalMacroField;
    
        mInternalMacroField = new MInternalMacroField(pName, this);
    
        return mInternalMacroField;
    }
    
    public MInternalStringField newInternalStringField(String pName){
        MInternalStringField mInternalStringField;
    
        mInternalStringField = new MInternalStringField(pName, this);
    
        return mInternalStringField;
    }
    
    public MContextField newContextField(){
        MContextField mContextField;
    
        mContextField = new MContextField(this);
    
        return mContextField;
    }
    
    public MMacroValueField newMacroValueField(){
        MMacroValueField mMacroValueField;
    
        mMacroValueField = new MMacroValueField(this);
    
        return mMacroValueField;
    }
    
    public MStringValueField newStringValueField(){
        MStringValueField mStringValueField;
    
        mStringValueField = new MStringValueField(this);
    
        return mStringValueField;
    }
    
    public MDirectiveFields newDirectiveFields(String pParamName){
        MDirectiveFields mDirectiveFields;
    
        mDirectiveFields = new MDirectiveFields(pParamName, this);
    
        return mDirectiveFields;
    }
    
    public MApplyInternalsInitializer newApplyInternalsInitializer(){
        MApplyInternalsInitializer mApplyInternalsInitializer;
    
        mApplyInternalsInitializer = new MApplyInternalsInitializer(this);
    
        return mApplyInternalsInitializer;
    }
    
    public MRedefinedInternalsSetter newRedefinedInternalsSetter(String pMacroName){
        MRedefinedInternalsSetter mRedefinedInternalsSetter;
    
        mRedefinedInternalsSetter = new MRedefinedInternalsSetter(pMacroName, this);
    
        return mRedefinedInternalsSetter;
    }
    
    public MStringPart newStringPart(String pString, String pIndexBuilder){
        MStringPart mStringPart;
    
        mStringPart = new MStringPart(pString, pIndexBuilder, this);
    
        return mStringPart;
    }
    
    public MEolPart newEolPart(String pIndexBuilder){
        MEolPart mEolPart;
    
        mEolPart = new MEolPart(pIndexBuilder, this);
    
        return mEolPart;
    }
    
    public MParamInsertPart newParamInsertPart(String pParamName, String pIndexBuilder){
        MParamInsertPart mParamInsertPart;
    
        mParamInsertPart = new MParamInsertPart(pParamName, pIndexBuilder, this);
    
        return mParamInsertPart;
    }
    
    public MIndentPart newIndentPart(String pIndexBuilder, String pIndexIndent){
        MIndentPart mIndentPart;
    
        mIndentPart = new MIndentPart(pIndexBuilder, pIndexIndent, this);
    
        return mIndentPart;
    }
    
    public MInsertMacroPart newInsertMacroPart(String pReferencedMacroName, String pIndexBuilder, String pIndexInsert){
        MInsertMacroPart mInsertMacroPart;
    
        mInsertMacroPart = new MInsertMacroPart(pReferencedMacroName, pIndexBuilder, pIndexInsert, this);
    
        return mInsertMacroPart;
    }
    
    public MInitStringBuilder newInitStringBuilder(String pIndexBuilder){
        MInitStringBuilder mInitStringBuilder;
    
        mInitStringBuilder = new MInitStringBuilder(pIndexBuilder, this);
    
        return mInitStringBuilder;
    }
    
    public MSetInternal newSetInternal(String pParamName, String pContext){
        MSetInternal mSetInternal;
    
        mSetInternal = new MSetInternal(pParamName, pContext, this);
    
        return mSetInternal;
    }
    
    public MNewStringValue newNewStringValue(String pIndexBuilder){
        MNewStringValue mNewStringValue;
    
        mNewStringValue = new MNewStringValue(pIndexBuilder, this);
    
        return mNewStringValue;
    }
    
    public MParamRef newParamRef(String pName){
        MParamRef mParamRef;
    
        mParamRef = new MParamRef(pName, this);
    
        return mParamRef;
    }
    
    public MAddIndent newAddIndent(String pIndexBuilder){
        MAddIndent mAddIndent;
    
        mAddIndent = new MAddIndent(pIndexBuilder, this);
    
        return mAddIndent;
    }
    
    public MStringValueArg newStringValueArg(String pIndex){
        MStringValueArg mStringValueArg;
    
        mStringValueArg = new MStringValueArg(pIndex, this);
    
        return mStringValueArg;
    }
    
    public MStringValue newStringValue(String pString){
        MStringValue mStringValue;
    
        mStringValue = new MStringValue(pString, this);
    
        return mStringValue;
    }
    
    public MMacroArg newMacroArg(String pName){
        MMacroArg mMacroArg;
    
        mMacroArg = new MMacroArg(pName, this);
    
        return mMacroArg;
    }
    
    public MStringArg newStringArg(String pName){
        MStringArg mStringArg;
    
        mStringArg = new MStringArg(pName, this);
    
        return mStringArg;
    }
    
    public MParamArg newParamArg(String pName){
        MParamArg mParamArg;
    
        mParamArg = new MParamArg(pName, this);
    
        return mParamArg;
    }
    
    public MPlainText newPlainText(String pPlainText){
        MPlainText mPlainText;
    
        mPlainText = new MPlainText(pPlainText, this);
    
        return mPlainText;
    }
    
    public MContextParam newContextParam(){
        MContextParam mContextParam;
    
        mContextParam = new MContextParam(this);
    
        return mContextParam;
    }
    
    public MContextArg newContextArg(){
        MContextArg mContextArg;
    
        mContextArg = new MContextArg(this);
    
        return mContextArg;
    }
    
    public MGetInternalTail newGetInternalTail(){
        MGetInternalTail mGetInternalTail;
    
        mGetInternalTail = new MGetInternalTail(this);
    
        return mGetInternalTail;
    }
    
    public MStringParam newStringParam(String pName){
        MStringParam mStringParam;
    
        mStringParam = new MStringParam(pName, this);
    
        return mStringParam;
    }
    
    public MAbstract newAbstract(){
        MAbstract mAbstract;
    
        mAbstract = new MAbstract(this);
    
        return mAbstract;
    }
    
    public MMacrosParam newMacrosParam(){
        MMacrosParam mMacrosParam;
    
        mMacrosParam = new MMacrosParam(this);
    
        return mMacrosParam;
    }
    
    public MPublic newPublic(){
        MPublic mPublic;
    
        mPublic = new MPublic(this);
    
        return mPublic;
    }
    
    public MOverride newOverride(){
        MOverride mOverride;
    
        mOverride = new MOverride(this);
    
        return mOverride;
    }
    
    public MClassNone newClassNone(){
        MClassNone mClassNone;
    
        mClassNone = new MClassNone(this);
    
        return mClassNone;
    }
    
    public MClassBeforeFirst newClassBeforeFirst(){
        MClassBeforeFirst mClassBeforeFirst;
    
        mClassBeforeFirst = new MClassBeforeFirst(this);
    
        return mClassBeforeFirst;
    }
    
    public MClassAfterLast newClassAfterLast(){
        MClassAfterLast mClassAfterLast;
    
        mClassAfterLast = new MClassAfterLast(this);
    
        return mClassAfterLast;
    }
    
    public MClassSeparator newClassSeparator(){
        MClassSeparator mClassSeparator;
    
        mClassSeparator = new MClassSeparator(this);
    
        return mClassSeparator;
    }
    
    public MExInternalException newExInternalException(){
        MExInternalException mExInternalException;
    
        mExInternalException = new MExInternalException(this);
    
        return mExInternalException;
    }
    
    public MExObjectMacroException newExObjectMacroException(){
        MExObjectMacroException mExObjectMacroException;
    
        mExObjectMacroException = new MExObjectMacroException(this);
    
        return mExObjectMacroException;
    }
    
    public MExIncorrectType newExIncorrectType(){
        MExIncorrectType mExIncorrectType;
    
        mExIncorrectType = new MExIncorrectType(this);
    
        return mExIncorrectType;
    }
    
    public MExObjectMacroErrorHead newExObjectMacroErrorHead(){
        MExObjectMacroErrorHead mExObjectMacroErrorHead;
    
        mExObjectMacroErrorHead = new MExObjectMacroErrorHead(this);
    
        return mExObjectMacroErrorHead;
    }
    
    public MExParameterNull newExParameterNull(){
        MExParameterNull mExParameterNull;
    
        mExParameterNull = new MExParameterNull(this);
    
        return mExParameterNull;
    }
    
    public MExMacroNullInList newExMacroNullInList(){
        MExMacroNullInList mExMacroNullInList;
    
        mExMacroNullInList = new MExMacroNullInList(this);
    
        return mExMacroNullInList;
    }
    
    public MExCannotModify newExCannotModify(){
        MExCannotModify mExCannotModify;
    
        mExCannotModify = new MExCannotModify(this);
    
        return mExCannotModify;
    }
    
    public MExCyclicReference newExCyclicReference(){
        MExCyclicReference mExCyclicReference;
    
        mExCyclicReference = new MExCyclicReference(this);
    
        return mExCyclicReference;
    }
    
    public MExVersionNull newExVersionNull(){
        MExVersionNull mExVersionNull;
    
        mExVersionNull = new MExVersionNull(this);
    
        return mExVersionNull;
    }
    
    public MMacroInternalException newMacroInternalException(){
        MMacroInternalException mMacroInternalException;
    
        mMacroInternalException = new MMacroInternalException(this);
    
        return mMacroInternalException;
    }
    
    public MExVersionsDifferent newExVersionsDifferent(){
        MExVersionsDifferent mExVersionsDifferent;
    
        mExVersionsDifferent = new MExVersionsDifferent(this);
    
        return mExVersionsDifferent;
    }
}